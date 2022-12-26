package com;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.net.URLDecoder;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fanjie
 * @date 2022/11/30 17:27
 */
public class FirewallTest {
    private static String TOKEN = "282E0fC2AA655C761290f8063996EC2f";
    private static final String SET_ACL = "https://192.168.57.12:8888/webui/acl/set";
    private static final String SET_TIME = "https://192.168.57.12:8888/webui/objoncetime/set";

    public static void main(String[] args) {
        FirewallTest firewallTest = new FirewallTest();
        JSONObject login = firewallTest.login();
        System.out.println(login);
        TOKEN = login.getStr("access_token");
        String aclName = "aclname_";
        String onceTime = firewallTest.setObjOnceTime(LocalDateTime.now(), aclName);
        firewallTest.setACL("1.1.1.1", "2.2.2.2", aclName, onceTime);



    }

    private String setObjOnceTime(LocalDateTime time, String aclName) {
        JSONObject params = new JSONObject();
        String timeOnce = MD5.create().digestHex(aclName).substring(0, 20);
        time = time.minusHours(1);
        LocalDateTime end = time.plusDays(7);
        params.set("undo", 0);
        params.set("timeonce", timeOnce);
        params.set("oncestartdate", String.format("%02d/%02d/%02d", time.getYear(), time.getMonthValue(), time.getDayOfMonth()));
        params.set("oncestarttime", String.format("%02d:%02d:%02d", time.getHour(), time.getMinute(), time.getSecond()));
        params.set("oncestopdate", String.format("%02d/%02d/%02d", end.getYear(), end.getMonthValue(), end.getDayOfMonth()));
        params.set("oncestoptime", String.format("%02d:%02d:%02d", end.getHour(), end.getMinute(), end.getSecond()));
        try (HttpResponse response = HttpUtil
                .createPost(SET_TIME)
                .cookie(new HttpCookie("access_token", TOKEN))
                .body(params.toString())
                .contentType("text/json")
                .execute()) {
            System.out.println(params);
            String bodyStr = response.body();
            System.out.println(bodyStr);
            JSONObject body = JSONUtil.parseObj(bodyStr);
            System.out.println(getErrorMsg(body));
            this.tokenTimeOut(body);
            System.out.println("==========");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeOnce;
    }

    private void setACL(String srcIp, String dstIp, String aclName, String timeObj) {
        JSONObject params = new JSONObject();
        params.set("acl_name", MD5.create().digestHex(aclName).substring(0, 15) + "_1");
        params.set("undo", 0);
        params.set("src_net", 1);
        params.set("dst_net", 1);
        params.set("src_ip", srcIp);
        params.set("dst_ip", dstIp);
        params.set("src_mask", "255.255.255.255");
        params.set("dst_mask", "255.255.255.255");
        params.set("time_object_name", timeObj);
        params.set("deny", 1);
        try (HttpResponse response = HttpUtil
                .createPost(SET_ACL)
                .cookie(new HttpCookie("access_token", TOKEN))
                .contentType("text/json")
                .body(params.toString())
                .execute()) {
            String bodyStr = response.body();
            System.out.println(bodyStr);
            JSONObject body = JSONUtil.parseObj(bodyStr);
            System.out.println(getErrorMsg(body));
            this.tokenTimeOut(body);
            System.out.println("==========");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public JSONObject login() {
        System.out.println("[firewall] start login.....");
        Map<String, Object> queryParam = new HashMap();
        queryParam.put("user", this.confuseStr(Base64.encode("administrator")));
        queryParam.put("psw", this.confuseStr(Base64.encode("administrator123")));
        queryParam.put("txt_language", "CN");
        queryParam.put("login_type", "password");
        queryParam.put("authened_type", 0);
        queryParam.put("soc_flag", 1);

        String url = String.format("https://%s%s","192.168.57.12:8888", "/webui/login/auth");
        System.out.println(url);
        String body = HttpUtil.get(url, queryParam);
        System.out.printf("[firewall] login done. result : %s%n", body);
        JSONObject response = JSONUtil.parseObj(body);
//        this.session.setAddress(firewallConfig.getAddress());
//        this.session.setUsername(firewallConfig.getUsername());
//        this.session.setPassword(firewallConfig.getPassword());
//        this.session.setToken(response.getJSONObject("data").getJSONObject("login").getString("access_token"));
        return response;
    }

    private void tokenTimeOut(JSONObject body) {
        if ("10".equals(body.getStr("result"))) {
            System.err.println("需要重新登录");
        }
    }

    private String getErrorMsg(JSONObject body) throws UnsupportedEncodingException {
        String errmsg = body.getStr("errmsg");
        if (StringUtils.isNotBlank(errmsg)) {
            if (errmsg.contains("ucode")) {
                String urlDecoder = errmsg.replaceAll("<ucode>", "").replaceAll("</ucode>", "");
                String base64 = URLDecoder.decode(urlDecoder, StandardCharsets.UTF_8);
                byte[] decode = Base64.decode(base64);
                return new String(decode, "GBK");
            }
        }
        return "";
    }

    private String confuseStr(String base64Str) {
        char[] chars = base64Str.toCharArray();

        for(int i = 0; i < chars.length; ++i) {
            if (chars[i] == 'a') {
                chars[i] = 'z';
            } else if (chars[i] == 'A') {
                chars[i] = 'Z';
            } else if (Character.isAlphabetic(chars[i])) {
                --chars[i];
            }
        }

        return new String(chars);
    }
}

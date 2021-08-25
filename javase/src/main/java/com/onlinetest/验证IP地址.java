package com.onlinetest;

import java.util.Scanner;

/**
 * @author Faster
 * @date 2019/9/16 20:53
 */
public class 验证IP地址 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ips = in.next();
        if (ips.split("\\.").length > 0) {
            boolean flag = checkIPV4(ips);
            if (flag) {
                System.out.println("IPv4");
                return;
            } else {
                System.out.println("Neither");
            }
        } else if (ips.split(":").length > 0) {
            boolean flag = checkIPV6(ips);
            if (flag) {
                System.out.println("IPv6");
                return;
            } else {
                System.out.println("Neither");
            }
        }
    }

    public static boolean checkIPV4(String ip) {
        String ss[] = ip.split("\\.");
        if (ss.length != 4)
            return false;
        for (int i = 0; i < ss.length; i++) {
            int num = Integer.parseInt(ss[i]);
            if (ss[i].startsWith("0") && num > 0) {
               return false;
            }
            if(num==0&&ss[i].length()>=2){
                return false;
            }
            if (num < 0 || num >= 256) {
               return false;
            }
        }
        return true;
    }

    public static boolean checkIPV6(String ip) {
        //65535
        String ss[] = ip.split("\\:");
        if (ss.length != 8)
            return false;
        for (int i = 0; i < ss.length; i++) {
            Integer num = Integer.parseInt(ss[i], 16);
            if (num == 0) {
                if (ss[i].length() >= 2) {
                    return false;
                }
            } else if(num<0){
                return false;
            }else if(num>65535){
                return false;
            }
        }
        return true;
    }
}

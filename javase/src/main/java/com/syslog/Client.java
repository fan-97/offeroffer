package com.syslog;

import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.SyslogConfigIF;
import org.productivity.java.syslog4j.SyslogConstants;
import org.productivity.java.syslog4j.SyslogIF;
import org.productivity.java.syslog4j.impl.AbstractSyslogConfigIF;
import org.productivity.java.syslog4j.impl.net.tcp.ssl.SSLTCPNetSyslogConfig;
import org.springframework.util.StopWatch;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Faster
 * @date 2019/12/30 19:31
 */
public class Client {
    private static final TimeUnit UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue WORK_QUEUE = new LinkedBlockingDeque();
    private static final int MAX_SEND_COUNT = 200;
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR =
            new ThreadPoolExecutor(200, 1000, 2, UNIT, WORK_QUEUE);

    static String msg = "{\"min_position\":4,\"has_more_items\":true,\"items_html\":\"Bike\",\"new_latent_count\":6,\"data\":{\"length\":26,\"text\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\"},\"numericalArray\":[27,27,27,24,24],\"StringArray\":[\"Carbon\",\"Carbon\",\"Nitrogen\",\"Carbon\"],\"multipleTypesArray\":true,\"objArray\":[{\"class\":\"lower\",\"age\":2},{\"class\":\"middle\",\"age\":5},{\"class\":\"lower\",\"age\":5},{\"class\":\"middle\",\"age\":6},{\"class\":\"lower\",\"age\":5}]}";

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            THREAD_POOL_EXECUTOR.execute(() -> {
                StopWatch sw = new StopWatch();
                sw.start();
                normal ();
                sw.stop();
                System.out.println(String.format("发送数据 %s 条，共计用时 %s 毫秒", MAX_SEND_COUNT, sw.getTotalTimeMillis()));
            });
        }

    }

    private static void normal() {
        SyslogIF client = Syslog.getInstance("udp");
        SyslogConfigIF config = client.getConfig();
        config.setPort(514);
        config.setHost("192.168.80.132");
        for (int i = 0; i < MAX_SEND_COUNT; i++) {
            client.info(msg);
        }
    }

    private static void ssl() {
        AbstractSyslogConfigIF configIF = new SSLTCPNetSyslogConfig();
        ((SSLTCPNetSyslogConfig) configIF).setTrustStore("E:/java/client.keystore");
        ((SSLTCPNetSyslogConfig) configIF).setTrustStorePassword("password");
        configIF.setHost("127.0.0.1");
        configIF.setThrowExceptionOnWrite(true);
        configIF.setPort(54000);
        Syslog.shutdown();
        SyslogIF syslogIF = Syslog.createInstance("tcp", configIF);
        syslogIF.log(SyslogConstants.LEVEL_DEBUG, "testtestestsetsetsetsetsets");
    }
}

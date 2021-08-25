package com.syslog;

import org.productivity.java.syslog4j.server.SyslogServer;
import org.productivity.java.syslog4j.server.SyslogServerConfigIF;
import org.productivity.java.syslog4j.server.SyslogServerIF;
import org.productivity.java.syslog4j.server.impl.event.printstream.SystemOutSyslogServerEventHandler;
import org.productivity.java.syslog4j.server.impl.net.tcp.ssl.SSLTCPNetSyslogServer;
import org.productivity.java.syslog4j.server.impl.net.tcp.ssl.SSLTCPNetSyslogServerConfig;
import org.productivity.java.syslog4j.server.impl.net.tcp.ssl.SSLTCPNetSyslogServerConfigIF;

/**
 * @author Faster
 * @date 2019/12/30 21:10
 */
public class Server {
    public static void main(String[] args) {
        normal();
    }

    private static void normal() {
        SyslogServerIF server = SyslogServer.getInstance("udp");
        SyslogServerConfigIF config = server.getConfig();
        config.setPort(514);
        config.setHost("192.168.123.100");
        config.addEventHandler(SystemOutSyslogServerEventHandler.create());
        System.out.println("server is started");
        System.out.println();
        server.run();

    }

    private static void ssl() {
        SSLTCPNetSyslogServer server = new SSLTCPNetSyslogServer();
        SSLTCPNetSyslogServerConfigIF configIF = new SSLTCPNetSyslogServerConfig();
        configIF.setKeyStore("E:/java/server.keystore");
        configIF.setKeyStorePassword("password");
        configIF.setHost("127.0.0.1");
        configIF.setPort(54000);
        server.initialize("tcp", configIF);
        System.out.println("server is starting...");
        server.run();
    }
}

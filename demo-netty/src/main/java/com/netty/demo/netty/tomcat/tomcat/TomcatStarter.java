package com.netty.demo.netty.tomcat.tomcat;

public class TomcatStarter {
    public static void main(String[] args) throws Exception {
        TomcatServer server = new TomcatServer("com.netty.demo.netty.tomcat.webapp");
        server.start();
    }
}

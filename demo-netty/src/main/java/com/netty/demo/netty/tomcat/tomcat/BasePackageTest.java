package com.netty.demo.netty.tomcat.tomcat;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2020/4/6 0006
 */
public class BasePackageTest {
    public static void main(String[] args) throws Exception {
        TomcatServer server = new TomcatServer("com.netty.demo.netty.tomcat.webapp");
        server.start();
    }
}

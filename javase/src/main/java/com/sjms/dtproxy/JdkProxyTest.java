package com.sjms.dtproxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        JdkProxyExample jdk = new JdkProxyExample();
        IHelloWorld helloWorld = (IHelloWorld) jdk.bind(new HelloWolrdImpl());
        helloWorld.sayFuckYou();
    }
}

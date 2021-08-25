package com;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author Faster
 * @date 2019/10/10 19:39
 */
public class Test1 {
    @Test
    public void jedisTest(){
        String host = "192.168.153.129";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);
        jedis.auth("root");
        System.out.println(jedis.ping());

    }

    @Test
    public void test2(){

    }
}

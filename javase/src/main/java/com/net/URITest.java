package com.net;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author fanjie
 * @date 2021/8/27 10:22
 */
public class URITest {
    public static void main(String[] args) {
        try {
            URI uri = new URI("/3/1");
            URI uri1 = new URI("/2");
            System.out.println(uri.compareTo(uri1));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

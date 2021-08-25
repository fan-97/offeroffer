package com.iostream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        while (s != null) {
            if (s.equals("exit")) break;
            System.out.println(s);
            s = br.readLine();
        }
        br.close();
        isr.close();
    }
}

package com.base;

import java.util.Scanner;

/**
 * @author Faster
 * @date 2019/9/17 17:05
 */
public class Test {

    public static void main(String[] args) {
        int n = 1;
        int x;
        // 和
        double sum = 0;
        // 每一项
        double term = 0;
        double limit = Math.pow(10,-5);
        Scanner sc = new Scanner(System.in);
        System.out.println("input x:");
        String s = sc.nextLine();
        x = Integer.parseInt(s);
        do {
            term = Math.pow(-1.0, n + 1) * (Math.pow(x, 2 * n - 1) / factorial(2 * n - 1));
            sum += term;
            System.out.println("terms:"+term);
            n++;
        } while (Math.abs(term) >= limit);
        System.out.println("sum=" + sum);
    }

    private static double factorial(int n) {
        double result = 1.0;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}

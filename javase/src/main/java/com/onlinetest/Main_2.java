package com.onlinetest;

import java.util.Scanner;

/**
 * @author Faster
 * @date 2019/9/6 19:52
 */
public class Main_2 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************
    1(2(3,4(,5)),6(7,))/
     */
    static String solution(String input) {

        return "";
    }

    /******************************结束写代码******************************/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
}

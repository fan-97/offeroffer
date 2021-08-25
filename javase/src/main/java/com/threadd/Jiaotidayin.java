package com.threadd;

/**
 * @author Faster
 * @date 2019/9/16 19:45
 */
public class Jiaotidayin {

    static int flag = 1;
    static Object obj = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                synchronized (obj) {
                    if (flag == 1) {
                        System.out.print("A:" + i + " ");
                        flag = 2;
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        obj.notifyAll();
                    }
                }

            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                synchronized (obj) {
                    if (flag == 2) {
                        System.out.println("B:" + i + " ");
                        flag = 1;
                        obj.notifyAll();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }

}


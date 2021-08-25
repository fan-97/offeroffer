package com.jvm;

public class GcTest1 {
    public static GcTest1 gc = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 被执行");
        GcTest1.gc = this;
    }

    private void isAlive(){
        System.out.println("I still alive");
    }

    public static void main(String[] args) throws InterruptedException {
        gc = new GcTest1();

        gc = null;//应该被JVM当作垃圾回收

        //对象的第一次拯救
        System.gc();
        Thread.sleep(500);//当要执行finalize方法的时候，JVM会自动创建一个优先级很低的线程来执行这个finalize方法。所以需要等待0.5s
        if (gc==null){
            System.out.println("i am a dead object");
        }else {
            gc.isAlive();
        }


        gc = null;//应该被JVM当作垃圾回收

        //对象的第二次拯救
        System.gc();
        Thread.sleep(500);
        if (gc==null){
            System.out.println("i am a dead object");
        }else {
            gc.isAlive();
        }
    }
}

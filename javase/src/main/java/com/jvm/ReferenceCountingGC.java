package com.jvm;

/**
 * testGC()执行后 objA和objB会不会被回收
 *
 * @author Faster
 * @date 2019/9/23 21:45
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 占内存，记录GC回收日志
     */
    private byte[] bigSize = new byte[2*_1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设发生GC，objA和objB是否能够被回收？
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }

}

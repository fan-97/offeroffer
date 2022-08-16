package com.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;

/**
 * Hello world!
 */
public class App {

    private static final int COUNT_BITS = 29;

    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    public static void main(String[] args) throws Exception {
        DirectMemoryReporter directMemoryReporter = new DirectMemoryReporter();

        UnpooledByteBufAllocator allocator = UnpooledByteBufAllocator.DEFAULT;
        ByteBuf buf1 = allocator.buffer(100);
        ByteBuf buf2 = allocator.directBuffer(900);
        System.out.println(buf2.readerIndex());
        allocator.directBuffer(900);

        System.out.println(buf1.getClass());
    }
}

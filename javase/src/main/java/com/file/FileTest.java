package com.file;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.StopWatch;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fanjie
 * @date 2021/7/17 16:33
 */
public class FileTest {
    private static final TimeUnit unit = TimeUnit.SECONDS;
    private static final BlockingQueue workQueue = new LinkedBlockingDeque();
    private static final ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(5, 5, 0, unit, workQueue);

    public static void main(String[] args) throws Exception {
        String[] filePath = {};
        for (String s : filePath) {
            POOL_EXECUTOR.execute(() -> {
                File file = new File(s);
                StopWatch sw = new StopWatch();
                sw.start("move file");
                try {
                    moveFile(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sw.stop();
                sw.prettyPrint();
            });
        }
    }

    private static void moveFile(File file) throws Exception {
        if (file.isFile()) {
            File parentFile = file.getParentFile().getParentFile();
            File destFile = new File(parentFile.getAbsoluteFile() + "/" + file.getName());
            FileCopyUtils.copy(file, destFile);
            System.out.println(String.format("拷贝文件 [%s] TO [%s] ", file.getAbsoluteFile(), destFile.getAbsoluteFile()));
            System.out.println(String.format("删除原文件 [%s] ", file.getName()));
            System.out.println(String.format("删除目录 [%s] ", file.getParentFile()));
            File parentFile1 = file.getParentFile();
            file.delete();
            parentFile.delete();
        } else {
            for (File listFile : file.listFiles()) {
                moveFile(listFile);
            }
        }
    }
}

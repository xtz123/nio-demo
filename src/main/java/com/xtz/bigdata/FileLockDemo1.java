package com.xtz.bigdata;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName FileLockDemo1
 * @Description 多个jvm的情况下的锁机制
 * @Author xutengzhong
 * @Date 2020/2/29 4:12
 **/
public class FileLockDemo1 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile out = new RandomAccessFile(new File("/Users/xutengzhong/Desktop/workspace/data/a.txt"), "rw");
        FileChannel channel = out.getChannel();

        channel.lock(0, Integer.MAX_VALUE, false);//true表示加共享锁

        System.out.println("开始写数据......");

        channel.write(ByteBuffer.wrap("xtz".getBytes()));

        channel.force(true);//这句话表示channel的数据需要强制落到磁盘，而不是os cache就结束。

        Thread.sleep(60 * 60 * 1000);


    }
}

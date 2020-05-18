package com.xtz.bigdata;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName FileLockDemo1
 * @Description TODO
 * @Author xutengzhong
 * @Date 2020/2/29 4:12
 **/
public class FileLockDemo1 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile in = new RandomAccessFile(new File("d:\\data\\a.txt"), "rw");
        FileChannel channel = in.getChannel();

        channel.lock(0, Integer.MAX_VALUE, false);//true表示加共享锁

        channel.write(ByteBuffer.wrap("xtz".getBytes()));

        //channel.force(true);//这句话表示channel的数据需要强制落到磁盘，而不是os cache就结束。

        Thread.sleep(60 * 60 * 1000);


    }
}

package com.xtz.bigdata;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName ChannelDemo1
 * @Description 测试随机写操作
 * @Author xutengzhong
 * @Date 2020/2/29 3:13
 **/
public class ChannelDemo2 {

    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("/Users/xutengzhong/Desktop/workspace/data/a.txt");
        FileChannel channel = out.getChannel();

        ByteBuffer buffer = ByteBuffer.wrap("hello world!!".getBytes());

        channel.write(buffer);

        System.out.println(buffer.position());
        System.out.println(channel.position());//channel也有posttion的概念

        buffer.rewind();//重新把之前的内容再写一遍
//        channel.write(buffer);//顺序追加数据

        channel.position(5);//随机写操作，需要自行指定position位置
        channel.write(buffer);
        channel.close();
        out.close();
    }
}

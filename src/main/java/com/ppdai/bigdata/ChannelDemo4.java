package com.ppdai.bigdata;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName ChannelDemo4
 * @Description 从磁盘读取数据
 * @Author xutengzhong
 * @Date 2020/2/29 3:48
 **/
public class ChannelDemo4 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("d:\\data\\a.txt");

        FileChannel channel = in.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(11);

        channel.read(buffer);

        buffer.rewind();

        byte[] bytes = new byte[11];
        buffer.get(bytes);

        System.out.println(new String(bytes));

    }
}

package com.xtz.bigdata;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName ChannelDemo1
 * @Description channel基本使用
 * @Author xutengzhong
 * @Date 2020/2/29 3:13
 **/
public class ChannelDemo1 {

    public static void main(String[] args) throws Exception{
        FileOutputStream out = new FileOutputStream("/Users/xutengzhong/Desktop/workspace/data/a.txt");
        FileChannel channel = out.getChannel();

        ByteBuffer buffer = ByteBuffer.wrap("hello world!!".getBytes());

        channel.write(buffer);

        channel.close();
        out.close();
    }
}

package com.xtz.bigdata;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName ChannelDemo1
 * @Description TODO
 * @Author xutengzhong
 * @Date 2020/2/29 3:13
 **/
public class ChannelDemo2 {

    public static void main(String[] args) throws Exception{
        FileOutputStream out = new FileOutputStream("d:\\data\\a.txt");
        FileChannel channel = out.getChannel();

        ByteBuffer buffer = ByteBuffer.wrap("hello world!!".getBytes());

        channel.write(buffer);

        System.out.println(buffer.position());
        System.out.println(channel.position());

        buffer.rewind();
        channel.position(5);

        channel.write(buffer);


        channel.close();
        out.close();
    }
}

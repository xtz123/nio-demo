package com.xtz.bigdata;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName ChannelDemo3
 * @Description channel是线程安全的
 * @Author xutengzhong
 * @Date 2020/2/29 3:42
 **/
public class ChannelDemo3 {

    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("d:\\data\\a.txt");
        FileChannel channel = out.getChannel();

        for (int i = 0; i < 10; i++) {
            ByteBuffer buffer = ByteBuffer.wrap("hello world!!".getBytes());
            new Thread() {
                @Override
                public void run() {
                    try {
                        channel.write(buffer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }


    }
}

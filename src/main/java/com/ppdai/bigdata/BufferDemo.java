package com.ppdai.bigdata;

import java.nio.ByteBuffer;

/**
 * @ClassName BufferDemo
 * @Description NIO之Buffer概念
 * @Author xutengzhong
 * @Date 2020/2/29 1:59
 **/
public class BufferDemo {

    public static void main(String[] args) {
        byte[] data = new byte[]{55, 24, 54, 86, 44};
        ByteBuffer buffer = ByteBuffer.wrap(data);

        //适用于从磁盘或者网络读取数据，为其分配一个空的字节数组
//        buffer=ByteBuffer.allocate(10);//非直连模式
//        buffer=ByteBuffer.allocateDirect(10);//采用直连模式


        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println("********************");
        System.out.println(buffer.get());
        buffer.mark();//在position=1的敌法昂mark一下
        System.out.println(buffer.position());

        System.out.println(buffer.get());
        System.out.println(buffer.get());
        buffer.reset();//重置，会回退到position mark的位置
        System.out.println(buffer.get());

    }
}

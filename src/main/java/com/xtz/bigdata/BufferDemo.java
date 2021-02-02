package com.xtz.bigdata;

import java.nio.ByteBuffer;

/**
 * @ClassName BufferDemo
 * @Description NIO之Buffer概念：position、capacity、limit
 * @Author xutengzhong
 * @Date 2020/2/29 1:59
 **/
public class BufferDemo {

    public static void main(String[] args) {
        byte[] data = new byte[]{55, 24, 54, 86, 44};
        //封装一个ByteBuffer
        ByteBuffer buffer = ByteBuffer.wrap(data);
        System.out.println(buffer.capacity());//5
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());//5

        System.out.println(buffer.get());//55,这时候position的位置会向后移动一位
        buffer.mark();//在position=1的地方mark一下
        System.out.println(buffer.position());//1
//
        System.out.println(buffer.get());//24
        System.out.println(buffer.get());//54
        buffer.reset();//重置，会回退到position mark的位置
        System.out.println(buffer.get());//24

        //适用于从磁盘或者网络读取数据，为其分配一个空的字节数组
//        buffer=ByteBuffer.allocate(10);//非直连模式
        System.out.println("********************");
        buffer=ByteBuffer.allocateDirect(10);//采用直连模式
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());



    }
}

package com.xtz.bigdata;

import java.nio.ByteBuffer;

/**
 * @ClassName BufferDemo
 * @Description NIO之Buffer概念
 * @Author xutengzhong
 * @Date 2020/2/29 1:59
 **/
public class BufferDemo2 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(100);
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());//100
        System.out.println(buffer.capacity());//100

        byte[] src = new byte[]{1, 2, 3, 4, 5};
        buffer.put(src);//插入数据以后，position的位置会向后移动
        System.out.println("****************");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("****************");
        buffer.position(0);//将其置为0才读取
        byte[] dest = new byte[5];//此时数据将进入dest数组中了
        buffer.get(dest);

        System.out.print("dest=[");
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i]);
            if (i < dest.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}

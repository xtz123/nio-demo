package com.xtz.bigdata;

import java.nio.ByteBuffer;

/**
 * @ClassName BufferTest
 * @Description TODO
 * @Author xutengzhong
 * @Date 2020/3/16 18:30
 **/
public class BufferTest {
    public static void main(String[] args) {
        byte[] bytes = {1, 2, 3, 4};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);

        System.out.println(buffer.position());

        System.out.println(buffer.capacity());

        System.out.println(buffer.limit());

        byte[] b1 = new byte[4];

        buffer.get(b1, 0, 4);

        buffer.flip();

        System.out.println(buffer.position());

        System.out.print("dest=[");
        for (int i = 0; i < b1.length; i++) {
            System.out.print(Byte.toString(b1[i]));
            if (i < b1.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");


//        byte[] b1 = new byte[4];
//
//        buffer.get(b1, 0, 2);
//
//        System.out.println(new String(b1));

    }
}

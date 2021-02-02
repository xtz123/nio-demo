package com.xtz.bigdata;

import java.nio.ByteBuffer;

/**
 * @ClassName FlipDemo
 * @Description flip()方法、rewind()方法
 * @Author xutengzhong
 * @Date 2020/2/29 2:54
 **/
public class BufferDemo3 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(100);

        byte[] bytes1 = new byte[]{1, 2, 3, 4, 5};

        buffer.put(bytes1);

        buffer.position(0);

        byte[] bytes2 = new byte[]{1, 2, 3};

        buffer.put(bytes2);

        System.out.println(buffer.position());

        /**
         * flip本质就是把limit设置为posttion，position=0,将mark舍弃
         * 场景：一般用在先写入一段数据，然后打算从零开始读取
         */
        buffer.flip();

        System.out.println(buffer.position());
        System.out.println(buffer.limit());


        byte[] bytes3 = new byte[3];
        buffer.get(bytes3);
//
        read(bytes3);
//
//        buffer.get();//此时执行这句会报错。flip是把limit设置为了本次写的position=3,并将position=0，所以不能读取超过的数据。


        /**
         * rewind是将position=0,将mark舍弃
         * 场景：一般用在先读取一段数据然后需要重新再读取一次
         */
        buffer.rewind();
        buffer.get(bytes3);
        read(bytes3);


    }

    private static void read(byte[] dest) {
        System.out.print("dest=[");
        for (int i = 0; i < dest.length; i++) {
            System.out.print(Byte.toString(dest[i]));
            if (i < dest.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}

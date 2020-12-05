package com.xtz.bigdata;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SocketServer
 * @Description 服务端能支持多个客户端的链接
 * @Author xutengzhong
 * @Date 2020/2/29 18:41
 **/
public class SocketServer2 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            Socket socket = serverSocket.accept();// 在这里会阻塞住，一直等待别人跟建立连接
            new Worker(socket).start();
        }
    }

    static class Worker extends Thread {
        Socket socket;

        public Worker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {

                // 如果有一个客户端跟他发起了TCP三次握手，尝试建立一个连接
                // 这里就会构建出来一个Socket，这个Socket就代表了跟某个客户端的一个TCP连接，Socket连接

                // 如果有人要跟你建立TCP连接，接下来基于TCP协议来传输数据，发送一个一个的TCP包过来
                // 此时他会必须是跟你的某个服务器程序的端口号建立的连接
                // 客户端跟你的ServerSocket之间，互相传递3次握手的TCP包，连接就建立，互相交换了一些数据


                // 接下来，一旦建立了TCP连接之后
                // 客户端就会通过IO流的方式发送数据过来，无限的流
                // 所以说底层的TCP协议会把流式的数据拆分为一个一个的TCP包，包裹在IP包里，以太网包
                // 最后通过底层的网络硬件设备以及以太网的协议，发送数据给你发送过来
                InputStreamReader in = new InputStreamReader(socket.getInputStream());
                OutputStream out = socket.getOutputStream();

                char[] buffer = new char[1024 * 1024];
                int len = in.read(buffer);
                if (len != -1) {
                    String request = new String(buffer, 0, len);
                    System.out.println("【"+Thread.currentThread().getName()+"】"+"服务端收到了请求:" + request);
                    out.write("收到，收到....".getBytes());

                    // 你需要反复的去读取socket流传输过来的数据
                    // 因为人家是不停的用流的方式发送数据过来的，你不需要不停的读取
                    // buf才1kb，可能你才读取了1kb的数据
                    // 后面可能还跟了几百kb的数据，所以需要你不停的读取

                    // 他的意思就是说，你通过IO流发送响应数据回去
                    // 此时在底层会把你的响应数据拆分为一个一个的TCP包，回传回去
                    // 客户端就可以接受到你发送的TCP包
                }

                out.close();
                in.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

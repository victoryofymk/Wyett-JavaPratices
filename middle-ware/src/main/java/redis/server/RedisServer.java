package redis.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * BIO模式不支持并发，阻塞后面所有的数据发送，多线程并发，每来一个请求，分配一个thread
 * 如何用单线程解决
 * @author yanmingkun
 * @date 2020-04-02 19:12
 */
public class RedisServer {
    static byte[] bytes=new byte[1024];
    public static void main(String[] args) throws IOException {
        ArrayList<Socket> sockets =new ArrayList<Socket>();
        ServerSocket serverSocket=new ServerSocket(6380);
        while (true){
            //阻塞，放弃CPU，什么都不干
            System.out.println("wai conn");
            Socket socket=serverSocket.accept();
            
            //将socket存在list，用户连接的socket都放在这
            if(socket!=null){
                sockets.add(socket);
            }

            //循环读取每个socket是否有数据
            for (Socket socket1 : sockets) {
                int read=socket.getInputStream().read(bytes);;
                if(read>0){
                    System.out.println(new String(bytes));
                }
                
            }

            
            System.out.println("conn success");
            //read也是阻塞
            System.out.println("wait data----");
            socket.getInputStream().read(bytes);
            System.out.println("data success----");
            System.out.println(new String(bytes));

        }
    }

}

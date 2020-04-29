package redis.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 * Nio Redis
 *
 * @author yanmingkun
 * @date 2020-04-02 22:41
 */
public class NioRedisServer {
    static ArrayList<SocketChannel> socketChannelArrayList = new ArrayList();
    static ByteBuffer byteBuffer = ByteBuffer.allocate(512);

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 6380));//调用操作系统
        serverSocketChannel.configureBlocking(false);//servletSocket非阻塞

        while (true) {
            for (SocketChannel socketChannel : socketChannelArrayList) {
                int read = socketChannel.read(byteBuffer);
                if (read > 0) {
                    System.out.println("read" + read);
                    byteBuffer.flip();

                    byte[] bytes = new byte[read];
                    byteBuffer.get(bytes);
                    String content = new String(bytes);
                    System.out.println(content);
                    byteBuffer.flip();
                }

            }
            SocketChannel socketChannel1 = serverSocketChannel.accept();
            if (socketChannel1 != null) {
                System.out.println("conn success");
                socketChannel1.configureBlocking(false);
                socketChannelArrayList.add(socketChannel1);
                System.out.println("连接数" + socketChannelArrayList.size());
            }
        }

    }
}

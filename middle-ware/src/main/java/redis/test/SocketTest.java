package redis.test;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author yanmingkun
 * @date 2020-04-02 19:12
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",6380);
        Scanner scanner=new Scanner(System.in);
        String next=scanner.next();
        socket.getOutputStream().write(next.getBytes());
        socket.close();

    }
}

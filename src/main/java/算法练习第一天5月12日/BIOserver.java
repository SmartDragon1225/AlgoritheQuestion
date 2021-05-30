package 算法练习第一天5月12日;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO 同步阻塞式I/O 面向流
 */
public class BIOserver {
    public static void main(String[] args) throws Exception{
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器启动了");
        while (true){
            System.out.println("等待连接中...");
            final Socket socket = serverSocket.accept();
            System.out.println("连接到了一个客户端");
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        handle(socket);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void handle(Socket socket) throws Exception {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true){
                int read = inputStream.read(bytes);
                if(read != -1){
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

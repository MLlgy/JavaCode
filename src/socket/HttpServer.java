package socket;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private void start() throws Exception {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(8881));
        System.out.println("---->>>> 服务器已经启动 <<<<----");

        while (true) {
            // 拿到 Socket 对象，为读取请求
            Socket socket = server.accept();

            InetSocketAddress address = (InetSocketAddress) socket.getRemoteSocketAddress();
            System.out.println("---->>>> 收到请求 <<<<----");
            System.out.println("HostName：" + address.getHostName());

            RequestHandler handler = new RequestHandler(socket);
            handler.start();
        }
    }

    public static void main(String[] args) {
        try {
            HttpServer http = new HttpServer();
            http.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}

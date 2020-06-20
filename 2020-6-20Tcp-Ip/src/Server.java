import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(9393)) {
            Socket socket = serverSocket.accept();  // 阻塞在这里

            pool.execute(() -> {
                handle(socket);
            });
        }
    }

    private static void handle(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream, "UTF-8");

            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();
                String response = run(request);

                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(response.getBytes("UTF-8"));
                outputStream.write("\r\n".getBytes("UTF-8"));
                outputStream.flush();
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String run(String request) {
        System.out.println("请求是: " + request);
        String response = request.toUpperCase();
        System.out.println("响应是: " + response);

        return response;
    }
}

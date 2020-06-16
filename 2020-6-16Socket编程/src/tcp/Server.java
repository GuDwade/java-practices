package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static  class ServerMan extends Thread{
        private final Socket socket;

        ServerMan(Socket socket){
            this.socket=socket;
        }
        @Override
        public void run() {
            try{
                InputStream is=socket.getInputStream();
                Scanner scanner=new Scanner(is,"UTF-8");
                String request=scanner.nextLine();
                System.out.println("收到请求："+request);

                String response=request;
                OutputStream os=socket.getOutputStream();
                PrintWriter writer=new PrintWriter(
                        new OutputStreamWriter(os,"UTF-8")
                );

                writer.println(response);
                writer.flush();
                socket.close();

            }catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9898);
        ExecutorService threadPool = Executors.newFixedThreadPool(20);

        while (true){
            Socket socket=serverSocket.accept();
            //new ServerMan(socket).start();
            threadPool.execute(new ServerMan(socket));
        }
    }
}

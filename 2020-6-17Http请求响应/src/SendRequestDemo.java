import java.io.*;
import java.net.Socket;

public class SendRequestDemo {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("www.baidu.com",80);
        OutputStream os=socket.getOutputStream();
        PrintWriter writer=new PrintWriter(new OutputStreamWriter(os,"UTF-8"));

        String request="GET / HTTP/1.0\r\n"
                + "Host: www.baidu.com\r\n"
                + "\r\n";

        writer.println(request);
        writer.flush();


        InputStream is=socket.getInputStream();
        byte[]buffer=new  byte[8192];
        int len=is.read(buffer);
        String response=new String(buffer,0,len,"UTF-8");

        System.out.println(response);
        socket.close();
    }
}

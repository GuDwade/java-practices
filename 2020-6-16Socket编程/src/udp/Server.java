package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建Server的Socket
        DatagramSocket socket=new DatagramSocket(9939);
        
        //2.处理请求
        while (true){
            action(socket);
        }
    }

    private static void action(DatagramSocket socket) throws IOException {
        byte []receiveBuffer=new byte[8192];
        //把buffer封装成 datagram
        DatagramPacket receivePacket=new DatagramPacket(receiveBuffer,0,8192);
        socket.receive(receivePacket);
        /*
        System.out.println(
                Arrays.toString(
                        Arrays.copyOfRange(receiveBuffer, 0, receivePacket.getLength())
                )
        );
       */
        String request=new String(receiveBuffer,0,receivePacket.getLength(),"UTF-8");
        System.out.println("收到的请求是:"+request);

        //回应
        String response=request;
        byte[]sendBuffer=response.getBytes("UTF-8");

        DatagramPacket sendPacket=new DatagramPacket(sendBuffer,0,sendBuffer.length,receivePacket.getAddress(),receivePacket.getPort());
        socket.send(sendPacket);
    }
}

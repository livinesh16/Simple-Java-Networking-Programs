import java.io.*;
import java.net.*;
public class DNSClient {
    public static void main(String args[]) throws IOException{
        try(DatagramSocket socket = new DatagramSocket()){
            byte req[] = "www.google.com".getBytes();
            DatagramPacket request = new DatagramPacket(req,req.length,InetAddress.getByName("localhost"),7000);
            socket.send(request);

            byte[] buf = new byte[100];
            DatagramPacket response = new DatagramPacket(buf,buf.length);
            socket.receive(response);
            String result = new String(response.getData(),0,response.getLength());
            System.out.println("IP Address : " + result);
        }
    }
}

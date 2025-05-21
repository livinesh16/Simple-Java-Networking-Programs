
import java.net.*;
// import java.util.*;
import java.io.*;
public class DNSServer {
    public static void main(String[] args) throws IOException{
        try(DatagramSocket dSocket = new DatagramSocket(7000)){
            byte[] buf = new byte[100];
            DatagramPacket request = new DatagramPacket(buf,buf.length);
            while(true){
                dSocket.receive(request);
                String domain = new String(request.getData(),0,request.getLength());
                
                try{
                    String ip = InetAddress.getByName(domain).getHostAddress();
                    System.out.println("Sent IP : " + ip);
                    byte[] response = ip.getBytes();
                    dSocket.send(new DatagramPacket(response,response.length,request.getAddress(),request.getPort()));
                }catch(UnknownHostException e){
                    System.out.println(e.getMessage());
                }
            }
            // socket.close();
            
        }
    }
}

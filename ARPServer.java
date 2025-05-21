import java.net.*;
import java.io.*;
import java.util.*;
public class ARPServer {
    public static void main(String[] args) throws IOException{
        try(ServerSocket serverSocket = new ServerSocket(8111)){
            System.out.println("Listening at port 8111");
            HashMap<String,String> addressMap = new HashMap<>();
            addressMap.put("192.168.1.2","aa:bb:cc:dd:ee:01");
            addressMap.put("192.168.1.1","aa:bb:cc:dd:ee:02");
            try(Socket socket = serverSocket.accept()){
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String ip = in.readLine();
                out.write(addressMap.get(ip));
                out.flush();
            }
        }
    }
}

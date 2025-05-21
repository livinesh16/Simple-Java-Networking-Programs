import java.io.*;
import java.net.*;
import java.util.*;
public class EchoClient {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost",8111);
            Scanner sc =new Scanner(System.in);){
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            String ip;
            while(true){
                ip = sc.nextLine();
                if(ip.equalsIgnoreCase("exit"))
                    break;
                out.write(ip + "\n");
                out.flush();
                
                System.out.println("Received : " + in.readLine());
            }
            sc.close();
            socket.close();
        }
    }
}

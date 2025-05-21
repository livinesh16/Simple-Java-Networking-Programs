import java.io.*;
import java.net.*;
import java.util.*;

public class ARPClient {
    public static void main(String[] args) throws IOException{
        try(Socket socket = new Socket("localhost",8111);
            Scanner sc = new Scanner(System.in)){
            System.out.print("IP Address : ");
            String input = sc.nextLine();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.write(input + "\n");
            out.flush();

            String response = in.readLine();
            System.out.println("MAC Address : " + response);
            socket.close();
            sc.close();
        }
    }
}

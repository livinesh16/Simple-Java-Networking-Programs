import java.io.*;
import java.net.*;
import java.util.*;


public class ChatClient {
    public static void main(String[] args) throws IOException{
        try(Socket socket = new Socket("localhost",8111);
            Scanner sc = new Scanner(System.in)){
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String response;
            while(true){
                response = in.readLine();
                if(response == null || response.equalsIgnoreCase("exit")){
                    System.out.println("Server Terminated ");
                    break;
                }
                System.out.println("Server : " + response);
                System.out.print("Client : ");
                String send = sc.nextLine();
                
                if(send.equalsIgnoreCase("exit")){
                    break;
                }

                out.write(send + "\n");
                out.flush();
            }
            sc.close();
            socket.close();
        }
    }    
}

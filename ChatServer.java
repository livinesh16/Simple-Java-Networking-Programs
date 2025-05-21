import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{
    public static void main(String args[]) throws IOException{
        try(ServerSocket serverSocket = new ServerSocket(8111)){
            System.out.println("Listening at port 8111");
            try(Socket socket = serverSocket.accept();
                Scanner sc = new Scanner(System.in);){
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String ip,serverMessage;
                while(true){
                    System.out.print("Server: ");
                    serverMessage = sc.nextLine();
                    out.write(serverMessage + "\n");
                    out.flush();

                    ip = in.readLine();
                    if(ip==null || ip.equalsIgnoreCase("exit")){
                        System.out.println("client Disconnected");
                        break;
                    }                
                    System.out.println("Client : " + ip);      
                }
                sc.close();
                socket.close();
            }
        }
    }
}

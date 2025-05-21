import java.io.*;
import java.net.*;
public class EchoServer {
    public static void main(String[] args) throws IOException{
        try(ServerSocket serverSocket = new ServerSocket(8111);){
            System.out.println("Listening at localhost:8111");
            while(true){
                try(Socket socket = serverSocket.accept()){
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    String line;
                    while((line = in.readLine())!=null){
                        System.out.println("Received " + line);
                        out.write(line + "\n");
                        out.flush();
                    }
                    socket.close();
                }
            }
        }
    }
}

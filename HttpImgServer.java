import java.io.*;
import java.net.*;
class HttpImgServer{
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8111)){
            System.out.println("Listening at port 8111");
            while(true){
                try(Socket socket = serverSocket.accept()){
                    OutputStream out = socket.getOutputStream();
                    byte[] image = java.nio.file.Files.readAllBytes(new File("image.jpg").toPath());
                    out.write(image);
                    socket.close();
                }
            }
        }
    }
}
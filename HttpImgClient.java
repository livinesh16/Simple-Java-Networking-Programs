import java.io.*;
import java.net.*;
class HttpImgClient{
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost",8111)){
            InputStream in = socket.getInputStream();
            ByteArrayOutputStream imageData = new ByteArrayOutputStream();
            int b;
            while((b = in.read())!=-1){
                imageData.write(b);
            }
            java.nio.file.Files.write(new File("result.jpg").toPath(),imageData.toByteArray());
            socket.close();
        }
    }
}
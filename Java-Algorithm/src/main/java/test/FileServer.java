package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(11111);
        System.out.println("Server started!");
        Socket client = socket.accept();
        System.out.println("Client accepted!");

        InputStream is = client.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        OutputStream os = client.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        String path = "src/main/java/test/";
        String msg = (String) ois.readObject();
        System.out.println(msg);
        File file = new File(path+msg);

        if(file.exists()){
            oos.writeUTF("200");
        }else {
            oos.writeUTF("404");
        }

        oos.flush();

        msg = (String) ois.readObject();

        FileInputStream fis = new FileInputStream(path+msg);
        int readBuffer = 0;
        byte [] buf = new byte[512];

        while((readBuffer = fis.read(buf)) != -1){
            oos.write(buf,0,readBuffer);
        }
        is.close();
        ois.close();
        os.close();
        oos.close();
        Thread.currentThread();
    }
}

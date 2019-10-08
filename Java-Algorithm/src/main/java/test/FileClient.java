package test;

import java.io.*;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost",11111);
        System.out.println("Client - Socket");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        System.out.println("파일 이름을 입력하세요.");
        String str = br.readLine();
        oos.writeObject(str);
        oos.flush();

        int responseCode = Integer.parseInt(ois.readUTF());
        if(responseCode == 200){
            oos.writeObject(str);
            oos.flush();

            String path = "src/main/java/test/";

            FileOutputStream fos = new FileOutputStream(new File(path+"clinet_"+str));

            byte[] buf = new byte[512];
            int readBytes;
            while ((readBytes = ois.read(buf)) != -1) {
                fos.write(buf, 0, readBytes);

            }
            os.close();
            ois.close();
            is.close();
            ois.close();
            fos.close();
        }


    }

}

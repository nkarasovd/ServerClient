import java.io.*;
import java.net.Socket;

public class Client {

    private Socket c;
    private InputStream is;
    private OutputStream os;

    public Client(Socket c) throws IOException {
        this.c = c;
        this.is = c.getInputStream();
        this.os = c.getOutputStream();
    }

    public void start() throws IOException {
        writeOutputStream();
        readInputStream();
    }

    public void writeOutputStream() throws IOException {
        String s = "GET /index.html HTTP/1.1\r\n\r\n";
        os.write(s.getBytes());
        os.flush();
    }

    public void readInputStream() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s = br.readLine();
        while (s!=null){
            System.out.println(s);
            s = br.readLine();
        }
    }
}
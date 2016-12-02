import java.net.*;
import java.io.*;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        Socket c = new Socket(InetAddress.getByName("localhost"), 8080);
        Client m = new Client(c);
        m.start();
    }
}
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Sergey Padzhev on 28.11.2016.
 */
public class ClientHandler implements Runnable {
    private MyServer owner; // ссылка на сервер, на котором работает ClientHandler
    private Socket s;
    private DataOutputStream out;
    private DataInputStream in;
    private String name;

    public ClientHandler(Socket s, MyServer owner){
        try {
            this.s = s;
            this.owner = owner;
            out = new DataOutputStream(s.getOutputStream());
            in = new DataInputStream(s.getInputStream());
            name = "";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendMsg(String msg) {
    }

    @Override
    public void run() {
        String t = SQLHandler.getNickByLoginPassword(n[1], n[2]);
    }
}

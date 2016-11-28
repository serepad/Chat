import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Sergey Padzhev on 28.11.2016.
 */
public class MyServer {
    private ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>(); // список клиентов храним в ArrayList

    public MyServer{
        ServerSocket server = null;
        Socket s = null;
        try {
            server = new ServerSocket(8189); //Создание сервера на порту 8189
            System.out.println("Server started. Waiting for clients connection.");
            while (true){
                s = server.accept();
                System.out.println("Client connected.");
    // когда создаётся обработчик ему передаётся ссылка на сервер, на котором он работает
                ClientHandler h = new ClientHandler(s, this);
                clients.add(h); // добавляем обработчик в список клиентов
                new Thread(h).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{   // Закрытие сервера
            try {
                server.close();
                System.out.println("Server closed.");
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

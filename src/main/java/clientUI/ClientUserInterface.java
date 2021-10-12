package clientUI;

import java.io.*;
import java.net.*;

public class ClientUserInterface {
    private Socket clientSocket;
    private ObjectOutputStream outbound;
    private ObjectInputStream inbound;

    public void Connect(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        outbound = new ObjectOutputStream(clientSocket.getOutputStream());
        inbound = new ObjectInputStream(clientSocket.getInputStream());
    }
    public boolean login(String username, String password) throws IOException, ClassNotFoundException {
        String message =  (String) inbound.readObject();
        System.out.println(message);
        outbound.writeObject(username);
        message = (String) inbound.readObject();
        System.out.println(message);
        outbound.writeObject(password);
        message = (String) inbound.readObject();
        System.out.println(message);
        return false;
    }
    public void disconnect() throws IOException {
        inbound.close();
        outbound.close();
        clientSocket.close();
    }
}

package clientUI;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientUserInterface {
    private Socket clientSocket;
    private ObjectOutputStream outbound;
    private ObjectInputStream inbound;

    public void Connect(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        outbound = new ObjectOutputStream(clientSocket.getOutputStream());
        inbound = new ObjectInputStream(clientSocket.getInputStream());
    }
    public boolean login(Scanner in) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        LoginRequest request = new LoginRequest(username, password);
        outbound.writeObject(request);
        outbound.flush();

    }
    public void disconnect() throws IOException {
        inbound.close();
        outbound.close();
        clientSocket.close();
    }
}

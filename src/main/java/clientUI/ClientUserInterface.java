package clientUI;

import action_request_response.LoginRequest;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientUserInterface {
    private Socket clientSocket;
    private ObjectOutputStream outbound;
    private ObjectInputStream inbound;

    public void Connect(String ip, int port) throws IOException, ClassNotFoundException {
        clientSocket = new Socket(ip, port);
        outbound = new ObjectOutputStream(clientSocket.getOutputStream());
        inbound = new ObjectInputStream(clientSocket.getInputStream());
        System.out.println( (String) inbound.readObject());
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        outbound.writeObject(answer);
        outbound.flush();

        if (answer == 1) {
            this.login();
        } else if (answer == 2) {
            this.createUser();
        } else {
            this.disconnect();
        }
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
        boolean temp = (Boolean) inbound.readObject();
        if (temp){
            System.out.println("Success");
            return true;
        }
        else{
            System.out.println("Failure");
            return false;
        }

    }
    public void disconnect() throws IOException {
        System.out.println("Disconnected");
        inbound.close();
        outbound.close();
        clientSocket.close();
    }
}

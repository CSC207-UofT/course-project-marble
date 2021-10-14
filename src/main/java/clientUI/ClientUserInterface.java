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
        System.out.println("Starting connection");
        clientSocket = new Socket(ip, port);
        outbound = new ObjectOutputStream(clientSocket.getOutputStream());
        inbound = new ObjectInputStream(clientSocket.getInputStream());
        System.out.println("Connected");
        System.out.println( (String) inbound.readObject());
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        outbound.writeObject(answer);
        outbound.flush();

        if (answer == 1) {
            boolean bool = this.login();
            if (!bool){
                System.out.println("Login failed exiting");
                disconnect();
                System.exit(-1);
            }
        } else if (answer == 2) {
            this.createUser();
        } else {
            this.disconnect();
        }
    }
    public void createUser() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = sc.nextLine();
        outbound.writeObject(name);
        outbound.flush();
        System.out.println("Please enter your chosen username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        outbound.writeObject(username);
        outbound.flush();
        outbound.writeObject(password);
        String message = (String) inbound.readObject();
        System.out.println(message);


    }

    public boolean login() throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        LoginRequest request = new LoginRequest(username, password);
        outbound.writeObject(request);
        outbound.flush();
        boolean temp = (Boolean) inbound.readObject();
        if (temp) {
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
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ClientUserInterface client = new ClientUserInterface();

        try {
            client.Connect("127.0.0.1", 8000);
        }
        catch (IOException | ClassNotFoundException e){
            System.exit(-1);
        }
        String input = "0";
        while (! input.equals("q")){
            System.out.println("Hello. You may now enter the following to do the following accounts");
            System.out.println("Check your balance enter: b");
            System.out.println("Deposit enter: d");
            System.out.println("Get your transaction history: h");
            System.out.println("Transfer money to someone else's account: t");
            System.out.println("View your accounts: v");
            System.out.println("Withdraw money: w");
            System.out.println("To quit: q");
            input = scan.nextLine();



        }

    }



}

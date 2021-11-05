package clientUI;

import action_request_response.CreateUserRequest;
import action_request_response.LoginRequest;
import action_request_response.UserQuitRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientUserInterface {
    private Socket clientSocket;
    private ObjectOutputStream outbound;
    private ObjectInputStream inbound;
    private String username;

    public void Connect(String ip, int port) throws IOException, ClassNotFoundException {
        System.out.println("Starting connection");
        clientSocket = new Socket(ip, port);
        outbound = new ObjectOutputStream(clientSocket.getOutputStream());
        inbound = new ObjectInputStream(clientSocket.getInputStream());
        System.out.println("Connected");
    }

    public boolean createUser() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your fullname");
        String fullname = sc.nextLine();
        System.out.println("Please enter your chosen username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        CreateUserRequest request = new CreateUserRequest(fullname, username, password);

        outbound.writeObject(request);
        outbound.flush();

        boolean result = (Boolean) inbound.readObject();
        if (result) {
            this.username = username;
            System.out.println("Thanks! You have created an account. " +
                    "You are now logged into it!");
            return true;
        } else {
            this.username = null;
            System.out.println("Username already exist. Please change to another username.");
            return false;
        }

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

        boolean result = (Boolean) inbound.readObject();
        System.out.println("Got result");
        if (result) {
            System.out.println("Success");
            this.username = username;
            return true;
        } else {
            this.username = null;
            System.out.println("Failure");
            return false;
        }
    }

    public void disconnect() throws IOException {
        UserQuitRequest request = new UserQuitRequest(this.username);
        outbound.writeObject(request);
        outbound.flush();
        System.out.println("Quit request flushed");
        inbound.close();
        outbound.close();
        clientSocket.close();
        System.out.println("Disconnected");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ClientUserInterface client = new ClientUserInterface();
        try {
            client.Connect("99.238.186.178", 8000);
        } catch (IOException | ClassNotFoundException e) {
            System.exit(-1);
        }

        while (client.username == null) {
            System.out.println("What do you want to do? Please return 1 to login or 2 to register!");
            System.out.println("Enter 'q' to exit the program");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();

            switch (answer) {
                case "1":
                    try {
                        boolean result = client.login();
                        if (!result) {
                            System.out.println("Login failed exiting");
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Invalid command");
                    }

                    break;
                case "2":
                    try {
                        boolean result = client.createUser();
                        if (!result) {
                            System.out.println("Login failed exiting");
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Invalid command");
                    }
                    break;
                case "q":
                    try {
                        client.disconnect();
                    } catch (IOException e) {
                        System.out.println("Caught an IO exception when closing socket connection");
                    }
                    return;
            }
        }

        String input = "0";
        while (!input.equals("q")) {
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
            try {
                client.disconnect();
            } catch (IOException e) {
                System.out.println("Caught an IO exception when closing socket connection");
            }
    }
}

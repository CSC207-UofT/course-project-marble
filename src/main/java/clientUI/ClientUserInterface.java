package clientUI;

import java.io.*;
import java.net.*;

public class ClientUserInterface {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream outbound;
    private ObjectInputStream inbound;
    private String ownerID = null;

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

    public static void main(String[] args) {
        // create a new client_user_interface called client
        // connect the client_user_interface to server (ip, port)

        System.out.println("Welcome to our Bank!");
        System.out.println("Please type 'Login' to login to your account");
        System.out.println("Type 'Quit' to exit the program");

        // String userInput = ""
        //
        // while userInput != "quit" {
        //      userInput = System input
        //
        //      while ownerID is null {
        //
        //          while userInput != "Login" {
        //              System.out.println("Please type 'Login' to login to your account");
        //              System.out.println("Type 'Quit' to exit the program");
        //              userInput = System input
        //          }
        //
        //          result = client.login(); // send LoginRequest to Server, get response, set ownerID to input ownerID
        //
        //          if result == True:
        //          System.out.println("Please select an action in 'Deposit', 'Transfer',
        //          'Withdrawal', 'View Account', 'CheckBalance', 'Get Transacton History'");
        //
        //          else:
        //          System.out.println("Login information is not right")
        //          System.out.println("Please type 'Login' to login to your account");
        //          System.out.println("Type 'Quit' to exit the program");
        //
        //      }
        //
        //      if userInput == "Transfer" {
        //          client.transfer();
        //      } else if ... {
        //          ...
        //      } else {
        //          System.out.println("Action not valid, please input another action.")
        //      }
        //
        //}
    }
}

package server;


import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.HashMap;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream outbound;
    private ObjectInputStream inbound;
//    private HashMap<String, String> passwords;
    private boolean auth;
    private boolean login;
    // storage server needed object

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        auth = false;
        outbound = new ObjectOutputStream(clientSocket.getOutputStream());
        inbound = new ObjectInputStream(clientSocket.getInputStream());

    }
    public boolean getAuth(){
        return auth;
    }

    public void createUser() throws IOException, ClassNotFoundException {
        this.outbound.writeObject("Hello what is your name?");
        String name = (String) this.inbound.readObject();
        outbound.writeObject("Great! Now what is your password?");
        String password = (String) this.inbound.readObject();
        this.outbound.writeObject("Thanks! You have created an account. You can now login to it");

    }
    public void stop () throws IOException {
        inbound.close();
        outbound.close();
        clientSocket.close();
        serverSocket.close();
        auth = false;
        }

    public Socket getNewSocket() {
        //implement this
        return null;
    }

    public boolean login() throws IOException, ClassNotFoundException {
        // implement this
        outbound.writeObject("Please enter your username");
        String username = (String) inbound.readObject();
        outbound.writeObject("Great! Now what is your password?");
        String pass = (String) inbound.readObject();

        
//        if (result) {
//            outbound.writeObject("That is the correct password!");
//            auth = true;
//            return true;
//        } else {
//            outbound.writeObject("That is incorrect");
//            auth = false;
//            return false;
//        }


        return false;
    }


    public static void main(String[] args) throws IOException{
            Server server = new Server();
            server.start(80);
        }
    }



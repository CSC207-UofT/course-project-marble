package server;


import clientUI.LoginRequest;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream outbound;
    private ObjectInputStream inbound;
//    private HashMap<String, String> passwords;
    private boolean auth;
    private boolean login;
    private OwnerRepository repository;
    private loggedInUser
    // storage server needed object

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        auth = false;
        outbound = new ObjectOutputStream(clientSocket.getOutputStream());
        inbound = new ObjectInputStream(clientSocket.getInputStream());
        OwnerRepository repository = new OwnerRepository();

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

    public void login() throws IOException, ClassNotFoundException {
        // implement this So what  we do: Login successful then
        // Send the owner instance to the clientUserInterface that made the request otherwise we send false
        // If it logged in then the user can see everything
        LoginRequest request = (LoginRequest) inbound.readObject();
        if (repository.loginCheck(request.getUsername(), request.getPassword())){
            outbound.writeObject("Your login request was successful!");
        }
        else{
            outbound.writeObject(false);
        }
    }


    public static void main(String[] args) throws IOException{
            Server server = new Server();
            server.start(8000);
        }
    }



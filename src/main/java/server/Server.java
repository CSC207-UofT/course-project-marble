package server;


import action_request_response.LoginRequest;
import entity.Owner;
import action_request_response.ActionRequest;
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
    private Owner loggedInUser;
    // storage server needed object

    public void start(int port) throws IOException, ClassNotFoundException {
        System.out.println("Starting server");
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        auth = false;
        outbound = new ObjectOutputStream(clientSocket.getOutputStream());
        inbound = new ObjectInputStream(clientSocket.getInputStream());
        repository = new OwnerRepository();
        outbound.writeObject("What do you want to do? Please return 1 to login or 2 to register!");
        outbound.flush();
        int answer = (int) inbound.readObject();
        if (answer == 1){
            this.login();
        }
        else if (answer == 2){
            this.createUser();
        }
        else{
            stop();
        }

    }
    public boolean getAuth(){
        return auth;
    }

    public void createUser() throws IOException, ClassNotFoundException {
        String name = (String) this.inbound.readObject();
        System.out.println(name);
        String username = (String) this.inbound.readObject();
        System.out.println(username);
        String password = (String) this.inbound.readObject();
        System.out.println(password);
        repository.createOwner(name, username, password);
        this.loggedInUser = repository.findOwner(username);
        this.outbound.writeObject("Thanks! You have created an account. You can are logged into it!");

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
            this.loggedInUser = repository.findOwner(request.getUsername());
            outbound.writeObject(true);
        }
        else{
            outbound.writeObject(false);
        }
        outbound.flush();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
            Server server = new Server();
            server.start(8000);
        }
    }



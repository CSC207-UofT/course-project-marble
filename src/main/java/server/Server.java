package server;


import action_request_response.LoginRequest;
import actions.CheckLogin;
import entity.Owner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream outbound;
    private ObjectInputStream inbound;
    //    private HashMap<String, String> passwords;
    private boolean login;
    private OwnerRepository repository;
    private Owner loggedInUser;
    // storage server needed object

    /**
     * This method starts the server and waits for the user to connect before sending options
     *
     * @param port The port we want the server to listen to. By default 8000 but needs to be changed
     */
    public void start(int port) throws IOException, ClassNotFoundException {

        /*
          This method starts the server and waits for the user to connect before sending options
          @param port: Port what we want the server to listen to. By default 8000 but needs to be changed
         */
        System.out.println("Starting server");
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        System.out.println("Connected");
        outbound = new ObjectOutputStream(clientSocket.getOutputStream());
        inbound = new ObjectInputStream(clientSocket.getInputStream());
        repository = new OwnerRepository();
        outbound.writeObject("What do you want to do? Please return 1 to login or 2 to register!");
        outbound.flush();
        int answer = (int) inbound.readObject();
        if (answer == 1) {
            this.login();
        } else if (answer == 2) {
            this.createUser();
        } else {
            stop();
        }

    }


    /**
     * Creates a user according to the client's requests and stores it in the OwnerRepository
     *
     * @throws IOException            Throws an IOException if the outbound or inbound runs into an issue
     * @throws ClassNotFoundException If the object that was received is not defined
     */
    public void createUser() throws IOException, ClassNotFoundException {
        String name = (String) this.inbound.readObject();
        System.out.println(name);
        String username = (String) this.inbound.readObject();
        System.out.println(username);
        String password = (String) this.inbound.readObject();
        System.out.println(password);
        repository.createOwner(name, username, password);
        this.loggedInUser = repository.findOwner(username);
        this.outbound.writeObject("Thanks! You have created an account. You  are now logged into it!");

    }

    /**
     * Closes all inbound and outbound connections and shuts the server down.
     *
     * @throws IOException For outbound and inbound streams
     */
    public void stop() throws IOException {
        inbound.close();
        outbound.close();
        clientSocket.close();
        serverSocket.close();
    }

    public Socket getNewSocket() {
        //implement this
        return null;
    }

    /**
     * Attempt to login the user
     *
     * @throws IOException            Inbound and outbound Streams don't work
     * @throws ClassNotFoundException Object that is sent is not Found
     */
    public void login() throws IOException, ClassNotFoundException {
        // implement this So what  we do: Login successful then
        // Send the owner instance to the clientUserInterface that made the request otherwise we send false
        // If it logged in then the user can see everything
        LoginRequest request = (LoginRequest) inbound.readObject();
        CheckLogin check = new CheckLogin(request);
        if (check.process()) {
            // outbound.writeObject("Your login request was successful!");
            this.loggedInUser = repository.findOwner(request.getUsername());
            outbound.writeObject(true);
        } else {
            outbound.writeObject(false);
        }
        outbound.flush();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        server.start(8000);
    }
}



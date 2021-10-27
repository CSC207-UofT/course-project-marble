package server;


import action_request_response.LoginRequest;
import actions.CheckLogin;
import actions.CreateOwner;
import entity.Owner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    protected static OwnerRepository repository;

    /**
     * This method starts the server and waits for the user to
     * connect before sending options
     *
     * @param port The port we want the server to listen to.
     *             By default 8000 but needs to be changed
     */
    public void start(int port) throws IOException {
        System.out.println("Starting server");
        this.serverSocket = new ServerSocket(port);
        System.out.printf("Server has started listening on port: %s%n", port);
        repository = OwnerRepository.getOwnerRepository();
    }

    public Socket accept() {
        Socket accept1 = null;
        try {
            accept1 = this.serverSocket.accept();
        } catch (IOException e) {
            System.out.println("No connection was found. Exiting");
            System.exit(-1);
        }
        return accept1;

    }

    /**
     * Closes all inbound and outbound connections and shuts the server down.
     *
     * @throws IOException For outbound and inbound streams
     */
    public void stop() throws IOException {
        this.serverSocket.close();
    }


    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(8000);
        Socket socket;
        Scanner sc = new Scanner(System.in);
        boolean checkNewUser = true;
        while (checkNewUser) {
            socket = server.accept();
            System.out.println("New Connection established");
            System.out.println("Do you want to allow a connection " +
                    "after this one? " +
                    "or stop here? Default is yes. y/n. ");
            String userInput = sc.nextLine();
            if (userInput.equals("no")) {
                checkNewUser = false;
            }
            new ServerThread(socket).start();
        }
    }


    static class ServerThread extends Thread {
        private final ObjectOutputStream outbound;
        private final ObjectInputStream inbound;
        Socket clientSocket;
        private Owner loggedInUser;

        ServerThread(Socket socket) throws IOException {
            this.clientSocket = socket;
            this.outbound = new ObjectOutputStream(clientSocket.getOutputStream());
            this.inbound = new ObjectInputStream(clientSocket.getInputStream());

        }

        @Override
        public void run() {
            System.out.println("Starting  sequence");
            int answer;
            try {
                answer = (int) inbound.readObject();
            } catch (IOException | ClassNotFoundException e) {
                return;
            }
            if (answer == 1) {
                try {
                    this.login();
                    if (this.loggedInUser == null) {
                        this.close();
                        return;
                    }
                } catch (IOException | ClassNotFoundException e) {
                    try {
                        this.close();
                    } catch (IOException e2) {
                        System.out.println("Caught an IO exception when closing socket connection");
                    }
                    return;
                }
            } else if (answer == 2) {
                try {
                    this.createUser();
                } catch (IOException | ClassNotFoundException e) {
                    try {
                        this.close();
                    } catch (IOException e2) {
                        System.out.println("Caught an IO exception when closing socket connection");
                    }
                    return;
                }
            }
            String message = "";
            while (!message.equals("q")) {
                try {
                    message = (String) inbound.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Invalid Message received. " +
                            "Cancelling connection");
                    message = "q";
                }
            }
            System.out.println("Disconnecting" + loggedInUser);
            try {
                this.close();
            } catch (IOException e) {
                System.out.println("Caught an IO exception when closing socket connection");
            }
        }

        void close() throws IOException {
            this.clientSocket.close();
        }

        private void login() throws IOException, ClassNotFoundException {
            // implement this So what  we do: Login successful then
            // Send the owner instance to the clientUserInterface that made the request
            //  otherwise we send false
            // If it logged in then the user can see everything
            LoginRequest request = (LoginRequest) inbound.readObject();
            CheckLogin check = new CheckLogin(request);
            if (check.process()) {
                this.loggedInUser = Server.repository.findOwner(request.getUsername());
                outbound.writeObject(true);
            } else {
                this.loggedInUser = null;
                outbound.writeObject(false);
            }
            outbound.flush();
        }

        private void createUser() throws IOException, ClassNotFoundException {
            String name = (String) inbound.readObject();
            System.out.println(name);
            String username = (String) inbound.readObject();
            System.out.println(username);
            String password = (String) inbound.readObject();
            System.out.println(password);
            CreateOwner create = new CreateOwner(name, username, password);
            if (create.process()) {
                this.loggedInUser = Server.repository.findOwner(username);
                outbound.writeObject(true);
            } else {
                this.loggedInUser = null;
                outbound.writeObject(false);
            }
            outbound.flush();
        }
    }
}




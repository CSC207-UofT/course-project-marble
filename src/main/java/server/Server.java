package server;


import action_request_response.ActionRequest;
import actions.Actions;

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
     *             By default, it is 8000 but needs to be changed
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
     */
    public void stop() {
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            System.out.println("Caught an IO exception when closing socket connection");
        }
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
            if (userInput.equals("n")) {
                checkNewUser = false;
            }
            new ServerThread(socket).start();
        }
        server.stop();
    }


    static class ServerThread extends Thread {
        private final ObjectOutputStream outbound;
        private final ObjectInputStream inbound;
        private final Socket  clientSocket;
        private final ActionFactory factory;

        ServerThread(Socket socket) throws IOException {
            this.clientSocket = socket;
            this.outbound = new ObjectOutputStream(clientSocket.getOutputStream());
            this.inbound = new ObjectInputStream(clientSocket.getInputStream());
            this.factory = new ActionFactory();

        }

        @Override
        public void run() {
            System.out.println("Starting sequence");
            boolean quit = false;

            while (!quit) {
                try {
                    ActionRequest request = (ActionRequest) this.inbound.readObject();
                    System.out.println("read object");

                    if (request.isQuit()) {
                        System.out.println("Disconnecting " + request.getUsername());
                        this.close();
                        quit = true;

                    } else {
                        Actions action = factory.getAction(request);
                        if (action != null) {
                            boolean result = action.process();
                            System.out.println("result " + result);
                            this.outbound.writeObject(result);
                            this.outbound.flush();
                            System.out.println("Flushed result");
                        }
                    }

                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Caught an IO exception when closing socket connection");
                    System.out.println("Disconnecting");
                    this.close();
                    quit = true;

                }
            }
        }

        void close() {
            try {
                this.clientSocket.close();
            } catch (IOException e) {
                System.out.println("Caught an IO exception when closing socket connection");
            }
        }

    }
}




package driver;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class Driver {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    // private passwords hashMap
    // storage server needed object

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out.println("Welcome to our Bank!");
        //call login function see if true
    }
        public void stop () throws IOException {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }

    public Socket getNewSocket() {
        //implement this
        return null;
    }

    public boolean login(){
        // implement this
        return false;
    }


    public static void main () throws IOException {
            Driver server = new Driver();
            server.start(80);
        }
    }



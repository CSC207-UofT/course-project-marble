package driver;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class Driver {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
        out.println("Welcome to our Bank!");
        //login details go below
    }
        public void stop () throws IOException {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }
        public static void main () throws IOException {
            Driver server = new Driver();
            server.start(80);
        }
    }



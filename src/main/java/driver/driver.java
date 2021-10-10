package driver;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class driver {
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
        if ("Hello".equals(greeting)) {
            out.println("Hello! Welcome to our Bank!");
        }
    }
        public void stop () throws IOException {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }
        public static void main () throws IOException {
            driver server = new driver();
            server.start(80);
        }
    }



package driver;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.HashMap;

public class Driver {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private HashMap<String, String> passwords;
    private boolean auth;
    // storage server needed object

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        passwords = new HashMap<String, String>();
        auth = false;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out.println("Welcome to our Bank!");
        out.println("Would you like to login to an existing user or create a new user?");


    }
    public boolean getAuth(){
        return auth;
    }
    public void createUser() throws IOException {
        out.println("Hello what is your name?");
        String name = in.readLine();
        out.println("Great! Now what is your password?");
        String password = in.readLine();
        passwords.put(name, password);
        out.println("Thanks! You have created an account. You can now login to it");

    }
    public void stop () throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
        auth = false;
        }

    public Socket getNewSocket() {
        //implement this
        return null;
    }

    public boolean login() throws IOException {
        // implement this
        out.println("Please enter your username");
       String username = in.readLine();
       out.println("Great! Now what is your password?");
       String pass = in.readLine();
        if (pass.equals(passwords.get(username))) {
            out.println("That is the correct password!");
            auth = true;
            return true;
        }
        else{
            out.println("That is incorrect");
            auth = false;
            return false;
        }


    }


    public static void main () throws IOException {
            Driver server = new Driver();
            server.start(80);
        }
    }



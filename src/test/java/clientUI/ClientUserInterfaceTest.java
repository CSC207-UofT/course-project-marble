package ClientUI;

import clientUI.ClientUserInterface;
import org.junit.jupiter.api.Test;
import server.Server;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ClientUserInterfaceTest {


    public static void main(String [] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        server.start(8000);
    }

    @Test
    void connectTestLocal() throws IOException, ClassNotFoundException {
    }

    @Test
    void connectTestSelfIp() throws IOException, ClassNotFoundException {
    }

    @Test
    void createUserLocal() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ClientUserInterface client = new ClientUserInterface();
        try {
            client.Connect("127.0.0.1", 8000);
        }
        catch (IOException | ClassNotFoundException e){
            assertTrue(false);
        }

    }

    @Test
    void login() {
    }

    @Test
    void disconnect() {
    }
}
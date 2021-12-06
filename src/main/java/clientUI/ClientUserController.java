package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientUserController {
    private Socket clientSocket;
    private ObjectOutputStream outbound;
    private ObjectInputStream inbound;
    private String username;

    public void Connect(String ip, int port) throws IOException, ClassNotFoundException {
        System.out.println("Starting connection");
        clientSocket = new Socket(ip, port);
        outbound = new ObjectOutputStream(clientSocket.getOutputStream());
        inbound = new ObjectInputStream(clientSocket.getInputStream());
        System.out.println("Connected");
    }

    public boolean sendObject(Object obj) {
        try {
            outbound.writeObject(obj);
            outbound.flush();
            return true;
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return false;
        }
    }

    public void disconnect() {
        ActionRequest request = new ActionRequest(this.username, Commands.USERQUIT, new ArrayList<>());
        sendObject(request);
        System.out.println("Quit sent");
        try {
            inbound.close();
            outbound.close();
            clientSocket.close();
            System.out.println("Disconnected");
        } catch (IOException e) {
            System.out.println("Caught an IO exception when closing socket connection");
        }
    }

    public boolean splash() {
        System.out.println("What do you want to do? Please return 1 to login or 2 to register!");
        System.out.println("Enter 'q' to exit the program");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        switch (answer) {
            case "1":
                username = new Login(outbound, inbound).login();
                return true;
            case "2":
                username = new CreateUser(outbound, inbound).createUser();
                return true;
            case "q":
                return false;
        }
        return false;
    }

    public void run() {
        Scanner scan = new Scanner(System.in);

        try {
            this.Connect("127.0.0.1", 8000);
        } catch (IOException | ClassNotFoundException e) {
            System.exit(-1);
        }

        while (this.username == null) {
            boolean tryAgain = this.splash();
            if (!tryAgain) {
                this.disconnect();
                return;
            }
        }

        new UpdateDepositable(outbound, inbound).updateDepositable(this.username);

        String input;
        boolean running = true;
        while (running) {
            Printer.menu();
            input = scan.nextLine();
            switch (input) {
                case "a":
                    new OwnerInfo(outbound, inbound).ownerInfo(this.username);
                    break;
                case "b":
                    new Deposit(outbound, inbound).deposit(this.username);
                    break;
                case "c":
                    new Withdrawal(outbound, inbound).withdrawal(this.username);
                    break;
                case "d":
                    new DisplayDepositRecord(outbound, inbound).displayDepositRecord(this.username);
                    break;
                case "e":
                    new DisplayWithdrawalRecord(outbound, inbound).displayWithdrawalRecord(this.username);
                    break;
                case "f":
                    new ViewInvestments(outbound, inbound).viewInvestment(this.username);
                    break;
                case "g":
                    new CashOut(outbound, inbound).cashout(this.username);
                    break;
                case "h":
                    new CreateBond(outbound, inbound).createBond(this.username);
                    break;
                case "i":
                    new CreateSavings(outbound, inbound).createSavings(this.username);
                    break;
                case "j":
                    new ChangeSavingsBalance(outbound, inbound).changeSavingsBalance(this.username);
                    break;
                case "k":
                    new CompareBudget(outbound, inbound).compareBudget(this.username);
                    break;
                case "l":
                    new DisplayBudget(outbound, inbound).displayBudget(this.username);
                    break;
                case "m":
                    new ViewBudgetPerformance(outbound, inbound).viewBudgetPerformance(this.username);
                    break;
                case "n":
                    new AdjustBudget(outbound, inbound).adjustBudget(this.username);
                    break;
                case "o":
                    new ResetBudget(outbound, inbound).resetBudget(this.username);
                    break;
                case "p":
                    new CalculateRemainingBudget(outbound, inbound).calculateRemainingBudget(this.username);
                    break;
                case "r":
                    new Simulate(outbound, inbound).simulate(this.username);
                    break;
                case "q":
                    this.disconnect();
                    running = false;
                    break;

            }
        }
    }
}

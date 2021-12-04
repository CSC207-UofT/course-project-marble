package clientUI;

import action_request_response.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
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

    public boolean sendObject(Object obj){
        try {
            outbound.writeObject(obj);
            outbound.flush();
            return true;
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return false;
        }
    }

    public boolean createUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your fullname");
        String fullName = sc.nextLine();
        System.out.println("Please enter your chosen username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();

        ActionRequest request = new ActionRequest(username, Commands.CREATEUSER,
                new ArrayList<>(List.of(fullName, password)));
        boolean connectionStatus = sendObject(request);
        if (!connectionStatus){
            return false;
        }
        try {
            CreateUserResponse result = (CreateUserResponse) inbound.readObject();
            if (result.getResult()) {
                this.username = username;
                System.out.println("Thanks! You have created an account. " +
                        "You are now logged into it!");
                return true;
            } else {
                this.username = null;
                System.out.println("Username already exist. Please change to another username.");
                return false;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred. Please try again");
            return false;
        }
    }

//    public boolean login() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter your username");
//        String username = sc.nextLine();
//        System.out.println("Please enter your password");
//        String password = sc.nextLine();
//        ActionRequest request = new ActionRequest(username, Commands.LOGIN, new ArrayList<>(List.of(password)));
//        boolean sendStatus = sendObject(request);
//        if (!sendStatus){
//            return false;
//        }
//        try {
//            LoginResponse result = (LoginResponse) inbound.readObject();
//            if (result.getResult()) {
//                this.username = username;
//                System.out.println("Login successful!");
//                return true;
//            } else {
//                this.username = null;
//                System.out.println("Login Failed. Please try again.");
//                return false;
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("An error occurred. Please try again");
//            return false;
//        }
//    }


    public void ownerInfo() {
        ActionRequest request = new ActionRequest(username, Commands.OWNERINFO, new ArrayList<>());
        sendObject(request);
        try {
            System.out.println("Processing");
            OwnerInfoResponse result = (OwnerInfoResponse) inbound.readObject();
            System.out.println(result.getDisplay());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred. Please try again");
        }
    }

    public void withdrawal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how much you want to withdraw");
        String amount = sc.nextLine();
        System.out.println("What category did you withdraw from?");
        String category = sc.nextLine();
        System.out.println("Why do you need this?");
        String description = sc.nextLine();
        ActionRequest request = new ActionRequest(this.username, Commands.WITHDRAWAL,
                new ArrayList<>(List.of(amount, category, description)));
        sendObject(request);
        boolean response;
        try {
            WithdrawalResponse result = (WithdrawalResponse) inbound.readObject();
            response = result.getResult();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
            return;
        }
        if (response) {
            System.out.println("Your withdrawal was successful!");
        } else {
            System.out.println("Your withdrawal could not be completed");
        }
    }

    public void displayWithdrawalRecord() {
        ActionRequest request = new ActionRequest(username, Commands.DISPLAYWITHDRAWALRECORD, new ArrayList<>());
        sendObject(request);
        try {
            DisplayWithdrawalRecordResponse result = (DisplayWithdrawalRecordResponse) inbound.readObject();
            System.out.println(result.getResult());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred. Please try again");
        }
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how much you want to deposit?");
        String amount = sc.nextLine();
        ActionRequest request = new ActionRequest(this.username,Commands.DEPOSIT, new ArrayList<>(List.of(amount)));
        sendObject(request);

        try {
            DepositResponse result = (DepositResponse) inbound.readObject();
            if (result.getResult()) {
                System.out.println("Deposit successfully");
            } else {
                System.out.println("Deposit failed. Please try again.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }
    }

    public void displayDepositRecord() {
        ActionRequest request = new ActionRequest(username, Commands.DISPLAYDEPOSITRECCORD, new ArrayList<>());
        sendObject(request);
        try {
            DisplayDepositRecordResponse result = (DisplayDepositRecordResponse) inbound.readObject();
            System.out.println(result.getResult());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }
    }

    public void updateDepositable() {
        ActionRequest request = new ActionRequest(this.username, Commands.UPDATEDEPOSITABLE, new ArrayList<>());
        sendObject(request);
        try {
            ActionResponse result = (ActionResponse) inbound.readObject();
            System.out.println("You were successful");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }
    }

    public void viewInvestments() {
        ActionRequest request = new ActionRequest(username, Commands.VIEWINVESTMENTS, new ArrayList<>());
        sendObject(request);
        try {
            ViewInvestmentsResponse result = (ViewInvestmentsResponse) inbound.readObject();
            System.out.println(result.getResult());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }
    }

//    public void cashOut() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("What is the name of the asset you want to cash out?");
//        String name = sc.nextLine();
//        ActionRequest request = new ActionRequest(username, Commands.CASHOUT, new ArrayList<>(List.of(name)));
//        sendObject(request);
//        try {
//            CashOutResponse result = (CashOutResponse) inbound.readObject();
//            boolean response = result.getResult();
//            if (response) {
//                System.out.println("You were successful");
//            } else {
//                System.out.println("You were not successful");
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("There was an error. Please try again");
//        }
//
//    }

    public void createSavings() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the savings accounts name?");
        String name = sc.nextLine();
        System.out.println("What is the interestRate?");
        String interestRate = sc.nextLine();
        ActionRequest request = new ActionRequest(this.username,Commands.CREATESAVINGS, new ArrayList<>(List.of(name, interestRate)));
        sendObject(request);
        try {
            ActionResponse result = (ActionResponse) inbound.readObject();
            System.out.println("You were successful");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }
    }

    public void createBond() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of the bond?");
        String name = sc.nextLine();
        System.out.println("What is the interestRate?");
        String interestRate = sc.nextLine();
        System.out.println("How much does each bond cost?");
        String pricePerBond = sc.nextLine();
        System.out.println("How many bonds did you buy?");
        String volume = sc.nextLine();
        System.out.println("What is the year of Maturity?");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("What is the month of Maturity?");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("What is the day of Maturity");
        int day = Integer.parseInt(sc.nextLine());

        String str_month = "0" + month;
        str_month = str_month.substring(str_month.length() - 2);

        String str_day = "0" + day;
        str_day = str_day.substring(str_day.length() - 2);

        String date = year + "-" + str_month + "-" + str_day;
        ActionRequest request = new ActionRequest(username, Commands.CREATEBOND,
                new ArrayList<>(List.of(name, interestRate, pricePerBond, volume, date)));
        sendObject(request);
        try {
            CreateBondResponse result = (CreateBondResponse) inbound.readObject();
            boolean response = result.getResult();
            if (response) {
                System.out.println("You were successful");
            } else {
                System.out.println("You do not have enough money to afford this purchase");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }
    }

//    public void changeSavingsBalance() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Which savings account?");
//        String name = sc.nextLine();
//        System.out.println("How much? +ve value to add to your savings. -ve to remove");
//        String amount = sc.nextLine();
//        ActionRequest request = new ActionRequest(username, Commands.DEPOSITSAVINGS, new ArrayList<>(List.of(name, amount)));
//        sendObject(request);
//        try {
//            DepositSavingResponse result = (DepositSavingResponse) inbound.readObject();
//            boolean response = result.getResult();
//            if (response) {
//                System.out.println("You were successful");
//            } else {
//                System.out.println("You do not have enough money to afford this purchase");
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("There was an error. Please try again");
//        }
//    }

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

    public boolean splash(){
        System.out.println("What do you want to do? Please return 1 to login or 2 to register!");
        System.out.println("Enter 'q' to exit the program");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        switch (answer) {
            case "1":
                username = new Login(outbound, inbound).login();
//                this.login();
//                return true;
            case "2":
                boolean result2 = this.createUser();
                if (!result2) {
                    System.out.println("Login failed exiting");
                }
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
            if (!tryAgain){
                this.disconnect();
                return;
            }
        }
        this.updateDepositable();
        String input;
        boolean running = true;
        while (running) {
            Printer.menu();
            input = scan.nextLine();
            switch (input) {
                case "a":
                    this.ownerInfo();
                    break;
                case "b":
                    this.deposit();
                    break;
                case "c":
                    this.withdrawal();
                    break;
                case "d":
                    this.displayDepositRecord();
                    break;
                case "e":
                    this.displayWithdrawalRecord();
                    break;
                case "f":
                    this.viewInvestments();
                    break;
                case "g":
                    //this.cashOut();
                    break;
                case "h":
                    this.createBond();
                    break;
                case "i":
                    this.createSavings();
                    break;
                case "j":
                    //this.changeSavingsBalance();
                    break;
                case "q":
                    this.disconnect();
                    running = false;
                    break;

            }
        }
    }
}

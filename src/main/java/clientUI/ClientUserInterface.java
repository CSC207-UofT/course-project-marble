package clientUI;

import action_request_response.*;
import entity.Date;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientUserInterface {
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

    public boolean createUser() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your fullname");
        String fullname = sc.nextLine();
        System.out.println("Please enter your chosen username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        CreateUserRequest request = new CreateUserRequest(fullname, username, password);


        outbound.writeObject(request);
        outbound.flush();

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

    }

    public boolean login() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        LoginRequest request = new LoginRequest(username, password);
        outbound.writeObject(request);
        outbound.flush();

        LoginResponse result = (LoginResponse) inbound.readObject();
        if (result.getResult()) {
            System.out.println("Success");
            this.username = username;
            return true;
        } else {
            this.username = null;
            System.out.println("Failure");
            return false;
        }
    }

    public void ownerInfo() {
        OwnerInfoRequest request = new OwnerInfoRequest(username);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("An error occurred. Please try again");
        }
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
        double amount = Double.parseDouble(sc.nextLine());
        System.out.println("What category did you withdraw from?");
        String category = sc.nextLine();
        System.out.println("Why do you need this?");
        String description = sc.nextLine();
        WithdrawalRequest request = new WithdrawalRequest(this.username, amount, category, description);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return;
        }
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
        DisplayWithdrawalRecordRequest request = new DisplayWithdrawalRecordRequest(username);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return;
        }
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
        double amount = Double.parseDouble(sc.nextLine());
        DepositRequest request = new DepositRequest(this.username, amount);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return;
        }

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
        DisplayDepositRecordRequest request = new DisplayDepositRecordRequest(this.username);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return;
        }

        try {
            DisplayDepositRecordResponse result = (DisplayDepositRecordResponse) inbound.readObject();
            System.out.println(result.getResult());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }
    }

    public void updateDepositable() {
        UpdateDepositableRequest request = new UpdateDepositableRequest(this.username);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
        }
        try {
            ActionResponse result = (ActionResponse) inbound.readObject();
            System.out.println("You were successful");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }
    }

    public void viewInvestments() {
        ViewInvestmentsRequest request = new ViewInvestmentsRequest(username);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return;
        }
        try {
            ViewInvestmentsResponse result = (ViewInvestmentsResponse) inbound.readObject();
            System.out.println(result.getResult());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }
    }

    public void cashOut() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of the asset you want to cash out?");
        String name = sc.nextLine();
        CashOutRequest request = new CashOutRequest(username, name);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return;
        }
        try {
            CashOutResponse result = (CashOutResponse) inbound.readObject();
            boolean response = result.getResult();
            if (response) {
                System.out.println("You were successful");
            } else {
                System.out.println("You were not successful");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }

    }
    public void createSavings(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the savings accounts name?");
        String name = sc.nextLine();
        System.out.println("What is the interestRate?");
        double interestRate = Double.parseDouble(sc.nextLine());
        CreateSavingRequest request = new CreateSavingRequest(this.username, interestRate, name);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
        }
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
        float interestRate = Float.parseFloat(sc.nextLine());
        System.out.println("How much does each bond cost?");
        double pricePerBond = Double.parseDouble(sc.nextLine());
        System.out.println("How many bonds did you buy?");
        int volume = Integer.parseInt(sc.nextLine());
        System.out.println("What is the year of Maturity?");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("What is the month of Maturity?");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("What is the day of Maturity");
        int day = Integer.parseInt(sc.nextLine());
        Date dateOfMaturity = new Date(month, day, year);
        CreateBondRequest request = new CreateBondRequest(this.username, name, interestRate, pricePerBond, volume, dateOfMaturity);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return;
        }
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

    public void changeSavingsBalance(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which savings account?");
        String name = sc.nextLine();
        System.out.println("How much? +ve value to add to your savings. -ve to remove");
        double amount = Double.parseDouble(sc.nextLine());
        DepositSavingRequest request = new DepositSavingRequest(username, name, amount);
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return;
        }
        try {
            DepositSavingResponse result = (DepositSavingResponse) inbound.readObject();
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

    /**
     * Stores the current OwnerRepo into a json via actions, this occurs before program terminates
     */
    private void storeOwnerRepo() {
        StoreDataInJsonRequest request = new StoreDataInJsonRequest("OwnerRepo.json");
        try {
            outbound.writeObject(request);
            outbound.flush();
        } catch (IOException e) {
            System.out.println("There was an error. Please try again.");
            return;
        }
        try {
            StoreDataInJsonResponse result = (StoreDataInJsonResponse) inbound.readObject();
            boolean response = result.getResult();
            if (response) {
                System.out.println("You were successful, data is stored");
            } else {
                System.out.println("You can't store the data");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again");
        }
    }


    public void disconnect() throws IOException {
        UserQuitRequest request = new UserQuitRequest(this.username);
        outbound.writeObject(request);
        outbound.flush();
        System.out.println("Quit request flushed");
        inbound.close();
        outbound.close();
        clientSocket.close();
        System.out.println("Disconnected");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ClientUserInterface client = new ClientUserInterface();
        try {
            client.Connect("127.0.0.1", 8000);
        } catch (IOException | ClassNotFoundException e) {
            System.exit(-1);
        }

        while (client.username == null) {
            System.out.println("What do you want to do? Please return 1 to login or 2 to register!");
            System.out.println("Enter 'q' to exit the program");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();

            switch (answer) {
                case "1":
                    try {
                        boolean result = client.login();
                        if (!result) {
                            System.out.println("Login failed exiting");
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Invalid command");
                    }
                    break;
                case "2":
                    try {
                        boolean result = client.createUser();
                        if (!result) {
                            System.out.println("Login failed exiting");
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Invalid command");
                    }
                    break;
                case "q":
                    try {
                        client.disconnect();
                    } catch (IOException e) {
                        System.out.println("Caught an IO exception when closing socket connection");
                    }
                    return;
            }
        }
        client.updateDepositable();
        String input;
        boolean running = true;
        while (running) {
            System.out.println("Hello. You may now enter the following:");
            System.out.println("Get basic owner info: a");
            System.out.println("Deposit enter: b");
            System.out.println("Withdraw money: c");
            System.out.println("View your deposit record history: d");
            System.out.println("View your withdrawal record history: e");
            System.out.println("View all of your assets: f");
            System.out.println("Cash out a non-depositable asset: g");
            System.out.println("Buy a new bond: h");
            System.out.println("Create a new savings account: i");
            System.out.println("Add or remove money from a Savings account : j");
            System.out.println("To quit: q");
            input = scan.nextLine();
            switch (input) {
                case "a":
                    client.ownerInfo();
                    break;
                case "b":
                    client.deposit();
                    break;
                case "c":
                    client.withdrawal();
                    break;
                case "d":
                    client.displayDepositRecord();
                    break;
                case "e":
                    client.displayWithdrawalRecord();
                    break;
                case "f":
                    client.viewInvestments();
                    break;
                case "g":
                    client.cashOut();
                    break;
                case "h":
                    client.createBond();
                    break;
                case "i":
                    client.createSavings();
                    break;
                case "j" :
                    client.changeSavingsBalance();
                    break;
                case "q":
                    try {
                        client.storeOwnerRepo();
                        client.disconnect();
                        running = false;
                        break;
                    } catch (IOException e) {
                        System.out.println("Caught an IO exception when closing socket connection");
                    }
                    break;

            }
        }
    }
}

package clientUI;

import action_request_response.ActionRequest;
import action_request_response.CashOutResponse;
import action_request_response.Commands;
import action_request_response.DepositResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deposit extends SendReceive{

    public Deposit(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }
    public void deposit(String username){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how much you want to deposit?");
        String amount = sc.nextLine();
        ActionRequest request = new ActionRequest(username, Commands.DEPOSIT, new ArrayList<>(List.of(amount)));
        sendReceiveObject(request);
        if (response != null) {
            if (((DepositResponse) response).getResult()) {
                System.out.println("Deposit successfully");
            } else {
                System.out.println("Deposit failed. Please try again.");
            }
        }
    }
}
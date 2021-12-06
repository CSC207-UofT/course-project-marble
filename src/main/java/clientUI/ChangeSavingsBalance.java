package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.DepositSavingResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ChangeSavingsBalance extends SendReceive {

    public ChangeSavingsBalance(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void changeSavingsBalance(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which savings account?");
        String name = sc.nextLine();
        System.out.println("How much? +ve value to add to your savings. -ve to remove");
        String amount = sc.nextLine();
        ActionRequest request = new ActionRequest(username, Commands.DEPOSITSAVINGS, new ArrayList<>(List.of(name, amount)));
        sendReceiveObject(request);
        if (response != null) {
            if (((DepositSavingResponse) response).getResult()) {
                System.out.println("You were successful");
            } else {
                System.out.println("You do not have enough money to afford this purchase");
            }
        }
    }
}
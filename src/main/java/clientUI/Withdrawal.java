package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.WithdrawalResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Withdrawal extends SendReceive {

    public Withdrawal(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void withdrawal(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how much you want to withdraw");
        String amount = sc.nextLine();
        System.out.println("What category did you withdraw from?");
        String category = sc.nextLine();
        System.out.println("Why do you need this?");
        String description = sc.nextLine();
        ActionRequest request = new ActionRequest(username, Commands.WITHDRAWAL,
                new ArrayList<>(List.of(amount, category, description)));
        sendReceiveObject(request);
        if (response != null) {
            if (((WithdrawalResponse) response).getResult()) {
                System.out.println("Your withdrawal was successful!");
            } else {
                System.out.println("Your withdrawal could not be completed");
            }
        }
    }
}

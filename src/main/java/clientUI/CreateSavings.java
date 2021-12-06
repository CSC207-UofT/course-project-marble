package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateSavings extends SendReceive {

    public CreateSavings(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void createSavings(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the savings accounts name?");
        String name = sc.nextLine();
        System.out.println("What is the interestRate?");
        String interestRate = sc.nextLine();
        ActionRequest request = new ActionRequest(username, Commands.CREATESAVINGS, new ArrayList<>(List.of(name, interestRate)));
        sendReceiveObject(request);
        if (response != null) {
            System.out.println("You were successful");
        }
    }
}

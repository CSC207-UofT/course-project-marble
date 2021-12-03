package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deposit {
    public ActionRequest deposit(String username){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how much you want to deposit?");
        String amount = sc.nextLine();
        return new ActionRequest(username, Commands.DEPOSIT, new ArrayList<>(List.of(amount)));
    }
}

package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Withdrawal {
    public ActionRequest withdrawal(String username){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how much you want to withdraw");
        String amount = sc.nextLine();
        System.out.println("What category did you withdraw from?");
        String category = sc.nextLine();
        System.out.println("Why do you need this?");
        String description = sc.nextLine();
        return new ActionRequest(username, Commands.WITHDRAWAL,
                new ArrayList<>(List.of(amount, category, description)));
    }
}

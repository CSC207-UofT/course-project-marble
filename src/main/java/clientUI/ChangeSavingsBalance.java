package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ChangeSavingsBalance {
    public ActionRequest changeSavingsBalance(String username){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which savings account?");
        String name = sc.nextLine();
        System.out.println("How much? +ve value to add to your savings. -ve to remove");
        String amount = sc.nextLine();
        ActionRequest request = new ActionRequest(username, Commands.DEPOSITSAVINGS, new ArrayList<>(List.of(name, amount)));
        return request;
    }
}

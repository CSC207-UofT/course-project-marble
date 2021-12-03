package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateSavings {
    public ActionRequest createSavings(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the savings accounts name?");
        String name = sc.nextLine();
        System.out.println("What is the interestRate?");
        String interestRate = sc.nextLine();
        return new ActionRequest(username, Commands.CREATESAVINGS, new ArrayList<>(List.of(name, interestRate)));
    }
}

package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashOut {
    public ActionRequest Cashout(String username){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of the asset you want to cash out?");
        String name = sc.nextLine();
        ActionRequest request = new ActionRequest(username, Commands.CASHOUT, new ArrayList<>(List.of(name)));
        return request;
    }
}

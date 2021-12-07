package clientUI;

import action_request_response.ActionRequest;
import action_request_response.AdjustBudgetResponse;
import action_request_response.Commands;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AdjustBudget extends SendReceive{
    public AdjustBudget(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void adjustBudget(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which category would you like to adjust your spending in?");
        String category = sc.nextLine();
        System.out.println("What is the amount you would like to adjust the category's spending to?");
        String newAmount = sc.nextLine();
        ActionRequest request = new ActionRequest(username, Commands.ADJUSTBUDGET, new ArrayList<>(List.of(category, newAmount)));
        sendReceiveObject(request);
        if (response != null) {
            if (Objects.equals(((AdjustBudgetResponse) response).getResult(), "Your actual amount has changed")){
                System.out.println("You were successful in adjusting your spending in the " + category + " category");
            }
            else{
                System.out.println("You were unsuccessful in adjusting your spending, please ensure that you have " +
                        "entered an existing valid category.");
            }
        }
    }
}

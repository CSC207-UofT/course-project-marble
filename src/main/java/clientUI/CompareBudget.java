package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.CompareBudgetResponse;
import action_request_response.DepositResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompareBudget extends SendReceive{
    public CompareBudget(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void compareBudget(String username){
        ActionRequest request = new ActionRequest(username, Commands.COMPAREBUDGET, new ArrayList<>());
        sendReceiveObject(request);
        if (response != null) {
            System.out.println(((CompareBudgetResponse) response).getDisplay());
        }
    }
}

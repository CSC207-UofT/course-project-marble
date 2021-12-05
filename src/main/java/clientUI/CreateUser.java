package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.CreateUserResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateUser extends SendReceive{
    public CreateUser(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }
    public String createUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your full name");
        String fullName = sc.nextLine();
        System.out.println("Please enter your chosen username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();

        ActionRequest request = new ActionRequest(username, Commands.CREATEUSER,
                new ArrayList<>(List.of(fullName, password)));
        sendReceiveObject(request);
        if (response != null) {
            if (((CreateUserResponse) response).getResult()) {
                System.out.println("Thanks! You have created an account. " +
                        "You are now logged into it!");
                return username;
            } else {
                System.out.println("Username already exist. Please change to another username.");
                return null;
            }
        }
        return null;
    }
}

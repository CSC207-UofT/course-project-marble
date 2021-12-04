package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateUser {
    public ActionRequest createUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your fullname");
        String fullName = sc.nextLine();
        System.out.println("Please enter your chosen username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();

        return new ActionRequest(username, Commands.CREATEUSER,
                new ArrayList<>(List.of(fullName, password)));
    }
}
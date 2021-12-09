package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.CreateBondResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateBond extends SendReceive {

    public CreateBond(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void createBond(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of the bond?");
        String name = sc.nextLine();
        System.out.println("What is the interestRate?");
        String interestRate = sc.nextLine();
        System.out.println("How much does each bond cost?");
        String pricePerBond = sc.nextLine();
        System.out.println("How many bonds did you buy?");
        String volume = sc.nextLine();
        System.out.println("What is the year of Maturity?");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("What is the month of Maturity?");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("What is the day of Maturity");
        int day = Integer.parseInt(sc.nextLine());

        String strYear = "" + year;
        String strMonth = "" + month;
        String strDay = "" + day;

        String date = strYear + "-" + strMonth + "-" + strDay;
        ActionRequest request = new ActionRequest(username, Commands.CREATEBOND,
                new ArrayList<>(List.of(name, interestRate, pricePerBond, volume, date)));
        sendReceiveObject(request);
        if (response != null) {
            if (((CreateBondResponse) response).getResult()) {
                System.out.println("You were successful");
            } else {
                System.out.println("You do not have enough money to afford this purchase");
            }
        }
    }
}

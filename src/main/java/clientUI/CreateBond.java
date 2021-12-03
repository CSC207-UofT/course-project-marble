package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateBond {
    public ActionRequest createBond(String username) {
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

        String str_month = "0" + month;
        str_month = str_month.substring(str_month.length() - 2);

        String str_day = "0" + day;
        str_day = str_day.substring(str_day.length() - 2);

        String date = year + "-" + str_month + "-" + str_day;
        return new ActionRequest(username, Commands.CREATEBOND,
                new ArrayList<>(List.of(name, interestRate, pricePerBond, volume, date)));
    }
}

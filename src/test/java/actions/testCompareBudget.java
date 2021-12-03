package actions;

import action_request_response.*;
import entity.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class testCompareBudget {
    private Owner owner;
    private final Date date = new Date(11, 13, 2021);
    private CompareBudgetRequest request;
    private CompareBudget callCompareBudget;

    @BeforeEach
    public void setup(){
        Owner own = new Owner("Sister Bear", "Sis", "honey");
        OwnerRepository.getOwnerRepository().addOwner(own);
        owner = OwnerRepository.getOwnerRepository().findOwner("Sis");
    }

    @AfterEach
    public void teardown(){
        OwnerRepository.getOwnerRepository().deleteOwner("Sis");
    }

    @Test
    public void testNoBudget(){
        request = new CompareBudgetRequest("Sis");
        callCompareBudget = new CompareBudget(request);
        ActionResponse result = callCompareBudget.process();
        String expected = "No Budget Formed to Compare\n";
        assertEquals(expected, ((CompareBudgetResponse)result).getDisplay());
    }

    @Test
    public void testHasBudget(){
        HashMap<String, Double> categories = new HashMap<String, Double>();
        categories.put("Needs", 200.0);
        categories.put("Wants", 50.0);
        categories.put("Savings/Investment", 750.0);
        owner.setBudget(categories, date, "monthly");

        request = new CompareBudgetRequest("Sis");
        callCompareBudget = new CompareBudget(request);
        ActionResponse result = callCompareBudget.process();
        String expected = "Total Amount to Budget: $1000.0\nBudget Based on 50/30/20 Rule: \nNeeds: $" +
                "500.0\nWants: $300.0\nInvestment/Debt: $200.0\nRemaining amount: " +
                "$0.00 \n ---------------\nCurrent Budget (from Categories written in):\n" +
                "Wants: $50.0\nNeeds: $200.0\nSavings/Investment: $750.0\n";
        assertEquals(expected, ((CompareBudgetResponse)result).getDisplay());
    }
}

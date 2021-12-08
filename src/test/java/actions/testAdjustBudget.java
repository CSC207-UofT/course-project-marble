package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.AdjustBudgetResponse;
import action_request_response.Commands;
import entity.Budget;
import entity.Date;
import entity.Owner;
import entity.OwnerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testAdjustBudget {
    private Owner owner;
    private HashMap<String, Double> categories;
    private final Date date = new Date(11, 13, 2021);
    private ActionRequest request;
    private Budget budget;
    @BeforeEach
    public void setup(){
        Owner newOwner = new Owner("Hunter Devon", "Hunter.D", "123");
        OwnerRepository.getOwnerRepository().addOwner(newOwner);
        owner = OwnerRepository.getOwnerRepository().findOwner("Hunter.D");
        budget = new Budget(date);
        budget.setGoalBudget("Groceries", 57.0);
        budget.setGoalBudget("Bill Payments", 25.0);
        budget.setGoalBudget("Entertainment", 95.0);
        budget.setGoalBudget("Public Transport", 50.75);
    }

    @AfterEach
    public void teardown() {OwnerRepository.getOwnerRepository().deleteOwner("Hunter.D");}

    @Test
    public void testSuccessAdjust(){
        owner.setBudget(budget);
        ArrayList<String> userInputs = new ArrayList<>(List.of("Gas", "189.67"));
        request = new ActionRequest("Hunter.D", Commands.ADJUSTBUDGET, userInputs);
        ActionResponse result = new AdjustBudget(request).process();
        assertTrue(((AdjustBudgetResponse) result).getResult());
    }

    @Test
    public void testFailAdjust(){
        owner.setBudget(budget);
        ArrayList<String> testInputs = new ArrayList<>(List.of("Cheese Funds", "98.77"));
        request = new ActionRequest("Hunter.D", Commands.ADJUSTBUDGET, testInputs);
        ActionResponse result = new AdjustBudget(request).process();
        assertFalse(((AdjustBudgetResponse) result).getResult());
    }

}
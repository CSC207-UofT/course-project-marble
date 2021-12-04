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

import static org.junit.jupiter.api.Assertions.*;

public class testAdjustBudget {
    private Owner owner;
    private HashMap<String, Double> categories;
    private final Date date = new Date(11, 13, 2021);
    private ActionRequest request;

    @BeforeEach
    public void setup(){
        Owner newOwner = new Owner("Hunter Devon", "Hunter.D", "123");
        OwnerRepository.getOwnerRepository().addOwner(newOwner);
        owner = OwnerRepository.getOwnerRepository().findOwner("Hunter.D");
        categories = new HashMap<>();
        categories.put("Needs", 1000.00);
        categories.put("Wants", 700.00);
        categories.put("Savings/Investment", 100.00);
    }

    @AfterEach
    public void teardown() {OwnerRepository.getOwnerRepository().deleteOwner("Hunter.D");}

    @Test
    public void testSuccessAdjust(){
        owner.setBudget(categories, date, "monthly");
        Budget budget = owner.getBudget();
        HashMap<String, Double> testCategories = new HashMap<>();
        testCategories.put("Needs", 900.00);
        testCategories.put("Wants", 700.00);
        testCategories.put("Savings/Investment", 100.00);
        budget.setRemainingBudget(testCategories);
        testCategories.put("Needs", 2000.00);
        ArrayList<String> testInput = new ArrayList<>();

        for(String key : testCategories.keySet()){
            testInput.add(key);
            testInput.add(String.valueOf(testCategories.get(key)));
        }
        request = new ActionRequest("Hunter.D", Commands.ADJUSTBUDGET, testInput);
        ActionResponse result = new AdjustBudget(request).process();
        assertTrue(((AdjustBudgetResponse) result).getResult());
        assertEquals(1900.00, owner.getBudget().getRemainingBudget().get("Needs"));
    }

    @Test
    public void testFailAdjust(){
        owner.setBudget(categories, date, "monthly");
        Budget budget = owner.getBudget();
        HashMap<String, Double> testCategories = new HashMap<>();
        testCategories.put("Needs", 500.00);
        testCategories.put("Wants", 700.00);
        testCategories.put("Savings/Investment", 100.00);
        budget.setRemainingBudget(testCategories);
        testCategories.put("Needs", 400.00);
        ArrayList<String> testInput = new ArrayList<>();

        for(String key : testCategories.keySet()){
            testInput.add(key);
            testInput.add(String.valueOf(testCategories.get(key)));
        }
        request = new ActionRequest("Hunter.D", Commands.ADJUSTBUDGET, testInput);
        ActionResponse result = new AdjustBudget(request).process();
        assertFalse(((AdjustBudgetResponse) result).getResult());
        assertEquals(500.00, owner.getBudget().getRemainingBudget().get("Needs"));
    }

}

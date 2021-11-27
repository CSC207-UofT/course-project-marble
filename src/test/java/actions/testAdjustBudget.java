package actions;

import action_request_response.ActionResponse;
import action_request_response.AdjustBudgetRequest;
import action_request_response.AdjustBudgetResponse;
import entity.Budget;
import entity.Date;
import entity.Owner;
import entity.OwnerRepository;

import javax.swing.*;
import java.util.HashMap;

public class testAdjustBudget {
    private Owner owner;
    private HashMap<String, Double> categories;
    private Date date = new Date(11, 13, 2021);
    private AdjustBudgetRequest request;
    private AdjustBudget callAdjustBudget;

    @BeforeEach
    public void setup(){
        Owner newOwner = new Owner("Hunter Devon", "Hunter.D", "123");
        OwnerRepository.getOwnerRepository().addOwner(newOwner);
        owner = OwnerRepository.getOwnerRepository().findOwner("Hunter.D");
        categories = new HashMap<String, Double>();
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
        categories.put("Needs", 900.00);
        budget.setRemainingBudget(categories);
        categories.put("Needs", 2000.00);
        request = new AdjustBudgetRequest("Hunter.D", categories);
        callAdjustBudget = new AdjustBudget(request);
        ActionResponse result = callAdjustBudget.process();
        assertTrue(((AdjustBudgetResponse)result).getResult());
        assertEquals(1900.00, owner.getBudget().getRemainingBudget().get("Needs"));
    }

    public void testFailAdjust(){
        owner.setBudget(categories, date, "monthly");
        Budget budget = owner.getBudget();
        categories.put("Needs", 500.00);
        budget.setRemainingBudget(categories);
        categories.put("Needs", 400.00);
        request = new AdjustBudgetRequest("Hunter.D", categories);
        callAdjustBudget = new AdjustBudget(request);
        ActionResponse result = callAdjustBudget.process();
        assertFalse(((AdjustBudgetResponse)result).getResult());
        assertEquals(500.00, owner.getBudget().getRemainingBudget().get("Needs"));
    }

}

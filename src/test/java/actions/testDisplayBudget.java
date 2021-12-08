package actions;

import action_request_response.*;
import entity.Budget;
import entity.Date;
import entity.Owner;
import entity.OwnerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDisplayBudget {
    private Owner owner;
    private ActionRequest request;
    private DisplayBudget callDisplayBudget;

    @BeforeEach
    public void setup(){
        Owner own = new Owner("Ei", "shogun", "et3rnity");
        OwnerRepository.getOwnerRepository().addOwner(own);
        owner = OwnerRepository.getOwnerRepository().findOwner("shogun");
    }

    @AfterEach
    public void teardown(){
        OwnerRepository.getOwnerRepository().deleteOwner("shogun");
    }

    @Test
    public void testNoBudget(){
        request = new ActionRequest("shogun", Commands.DISPLAYBUDGET, new ArrayList<>());
        callDisplayBudget = new DisplayBudget(request);
        ActionResponse result = callDisplayBudget.process();
        String expected = "No Active or Existing Budget to View";
        assertEquals(expected, ((DisplayBudgetResponse)result).getResult());
    }

    @Test
    public void testInactiveBudget(){
        Budget budget = new Budget(new Date(1, 1,2021));
        budget.setActive(false);
        owner.setBudget(budget);
        request = new ActionRequest("shogun", Commands.DISPLAYBUDGET, new ArrayList<>());
        callDisplayBudget = new DisplayBudget(request);
        ActionResponse result = callDisplayBudget.process();
        String expected = "No Active or Existing Budget to View";
        assertEquals(expected, ((DisplayBudgetResponse)result).getResult());
    }

    @Test
    public void testActiveBudget(){
        Budget budget = new Budget(new Date(1, 1,2021));
        owner.setBudget(budget);
        request = new ActionRequest("shogun", Commands.DISPLAYBUDGET, new ArrayList<>());
        callDisplayBudget = new DisplayBudget(request);
        ActionResponse result = callDisplayBudget.process();
        String expected = "Budget Created on: 1/1/2021\n" + "The total budget amount is: $0.0\n" +
                " Budget Broken Down:\n" +
                "\t Category Name: Groceries\n\t\t Goal Budget: $0.0\n\t\t Money Spent: $0.0\n" +
                "\t Category Name: Entertainment\n\t\t Goal Budget: $0.0\n\t\t Money Spent: $0.0\n"+
                "\t Category Name: Gas\n\t\t Goal Budget: $0.0\n\t\t Money Spent: $0.0\n" +
                "\t Category Name: Bill Payments\n\t\t Goal Budget: $0.0\n\t\t Money Spent: $0.0\n"+
                "\t Category Name: Public Transport\n\t\t Goal Budget: $0.0\n\t\t Money Spent: $0.0\n";
        assertEquals(expected, ((DisplayBudgetResponse)result).getResult());
    }
}

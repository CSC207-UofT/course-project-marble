package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.Commands;
import action_request_response.CalculateRemainingBudgetResponse;
import entity.Budget;
import entity.Date;
import entity.Owner;
import entity.OwnerRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class testCalculateRemainingBudget {
    private Owner owner;
    private Budget budget;
    private ActionRequest request;
    private CalculateRemainingBudget action;

    @BeforeEach
    public void setup(){
        Owner own = new Owner("Penelope Eckart", "villain", "3clip$e");
        OwnerRepository.getOwnerRepository().addOwner(own);
        owner = OwnerRepository.getOwnerRepository().findOwner("villain");
        budget = new Budget(new Date(1, 1,2021));
    }

    @AfterEach
    public void teardown(){
        OwnerRepository.getOwnerRepository().deleteOwner("villain");
    }
    //Test if Owner has no budget and if Owner has no active budget
    @Test
    public void testNoBudget() {
        String expected = "Budget Inactive or Does Not Exist";
        ActionRequest request = new ActionRequest("villain", Commands.CALCULATEREMAININGBUDGET,
                new ArrayList<>());
        action = new CalculateRemainingBudget(request);
        ActionResponse response = action.process();
        assertEquals(((CalculateRemainingBudgetResponse)response).getResult(), expected);
    }
    @Test
    public void testInactiveBudget(){
        String expected = "Budget Inactive or Does Not Exist";
        budget.setActive(false);
        owner.setBudget(budget);
        ActionRequest request = new ActionRequest("villain", Commands.CALCULATEREMAININGBUDGET,
                new ArrayList<>());
        action = new CalculateRemainingBudget(request);
        ActionResponse response = action.process();
        assertEquals(((CalculateRemainingBudgetResponse)response).getResult(), expected);
    }

    //Tests for an active budget
    @Test
    public void testHasActiveBudget(){
        String expected = "You have the following amounts left in each category: \n" +
                "Groceries: 0.0\n" + "Gas: 0.0\n"+ "Bill Payments: 0.0\n"+ "Entertainment: 0.0\n" +
                "Public Transport: 0.0\n";
        owner.setBudget(budget);
        ActionRequest request = new ActionRequest("villain", Commands.CALCULATEREMAININGBUDGET,
                new ArrayList<>());
        action = new CalculateRemainingBudget(request);
        ActionResponse response = action.process();
        assertEquals(((CalculateRemainingBudgetResponse)response).getResult(), expected);
    }

}

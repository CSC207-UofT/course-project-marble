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
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testResetBudget {
    private Owner user;
    private HashMap<String, Double> categories;
    private final Date date = new Date(11, 13, 2021);
    private ActionRequest request;
    private Budget budget;
    @BeforeEach
    public void setup(){
        ActionRequest createUserRequest = new ActionRequest("jd_123", Commands.CREATEUSER,new ArrayList<>(List.of("John Doe","password")));
        CreateOwner createUser = new CreateOwner(createUserRequest);
        createUser.process();
        user = OwnerRepository.getOwnerRepository().findOwner("jd_123");
        budget = new Budget(date);
        budget.setGoalBudget("Groceries", 340.0);
        budget.setGoalBudget("Bill Payments", 2500.0);
        budget.setActualSpending("Groceries", 100.0);
        budget.setActualSpending("Bill Payments", 1000.0);
    }

    @AfterEach
    public void teardown() {OwnerRepository.getOwnerRepository().deleteOwner("jd_123");}

    @Test
    public void testResetSuccess(){
        user.setBudget(budget);
        request = new ActionRequest("jd_123", Commands.RESETBUDGET, new ArrayList<>());
        ActionResponse result = new ResetBudget(request).process();
        String expected = "The total remaining budget from last month is: $1740.0";
        assertEquals(((ResetBudgetResponse) result).getResult(), expected);
        assertEquals(user.getBudget().getActualSpending("Groceries"), 0.0);
        assertEquals(user.getBudget().getActualSpending("Bill Payments"), 0.0);
    }
    @Test
    public void testResetFailure(){
        budget.setActive(false);
        user.setBudget(budget);
        request = new ActionRequest("jd_123", Commands.RESETBUDGET, new ArrayList<>());
        ActionResponse result = new ResetBudget(request).process();
        String expected = "Budget Inactive or Does Not Exist";
        assertEquals(((ResetBudgetResponse) result).getResult(), expected);
    }
}

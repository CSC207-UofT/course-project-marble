package actions;

import action_request_response.ActionResponse;
import action_request_response.AddExpenseRequest;
import action_request_response.AddExpenseResponse;
import entity.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class testAddExpense {
    private Owner owner;
    private HashMap<String, Double> categories;
    private Date date = new Date(11, 13, 2021);
    private AddExpenseRequest request;
    private AddExpense callAddExpense;

    @BeforeEach
    public void setup(){
        Owner own = new Owner("Hannibal Lector", "H.Lector", "yum");
        OwnerRepository.getOwnerRepository().addOwner(own);
        owner = OwnerRepository.getOwnerRepository().findOwner("H.Lector");
        categories = new HashMap<String, Double>();
        categories.put("Needs", 1005.79);
        categories.put("Wants", 700.69);
        categories.put("Savings/Investment", 666.66);


    }
    @AfterEach
    public void teardown(){
        OwnerRepository.getOwnerRepository().deleteOwner("H.Lector");
    }

    @Test
    public void testTypicalAddExpense(){
        owner.setBudget(categories, date, "monthly");
        request = new AddExpenseRequest("H.Lector", "Needs", 150.29);
        callAddExpense = new AddExpense(request);
        ActionResponse result = callAddExpense.process();
        assertTrue(((AddExpenseResponse)result).getResult());
        assertEquals(855.5, owner.getBudget().getRemainingBudget().get("Needs"));
    }

    @Test
    public void testBudgetDoesNotExist(){
        request = new AddExpenseRequest("H.Lector", "Needs", 150.29);
        callAddExpense = new AddExpense(request);
        ActionResponse result = callAddExpense.process();
        assertFalse(((AddExpenseResponse)result).getResult());
    }

    @Test
    public void testNotEnoughBudget(){
        owner.setBudget(categories, date, "monthly");
        request = new AddExpenseRequest("H.Lector", "Needs", 1500.29);
        callAddExpense = new AddExpense(request);
        ActionResponse result = callAddExpense.process();
        assertFalse(((AddExpenseResponse)result).getResult());
        assertEquals(1005.79, owner.getBudget().getRemainingBudget().get("Needs"));
    }

}

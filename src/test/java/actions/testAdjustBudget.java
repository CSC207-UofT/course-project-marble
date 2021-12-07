package actions;
import action_request_response.*;
import entity.Owner;
import entity.OwnerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
/**
 * Activates of deactivates the owner's budget depending on its state (true, false)
 * If it's active, set it no non-active.
 * If it's deactivated, activate it.*/


public class testAdjustBudget {

    private Owner owner;
    private ActionRequest request;
    private AdjustBudget adjustBudget;

    @BeforeEach
    public void setup(){
        Owner own = new Owner("Winnie the Pooh", "Pooh", "honey");
        OwnerRepository.getOwnerRepository().addOwner(own);
        owner = OwnerRepository.getOwnerRepository().findOwner("Pooh");

    }

    @AfterEach
    public void teardown(){
        OwnerRepository.getOwnerRepository().deleteOwner("Pooh");
    }

    @Test
    public void testInactiveAdjustBudgetSuccess(){
        request = new ActionRequest("Pooh", Commands.ADJUSTBUDGET, new ArrayList<>(List.of("Groceries", "55.00")));
        adjustBudget = new AdjustBudget(request);
        ActionResponse result = adjustBudget.process();

        String expected = "Your budget is not activated. Please try again.";
        assertEquals(expected, ((AdjustBudgetResponse)result).getResult());
    }



}

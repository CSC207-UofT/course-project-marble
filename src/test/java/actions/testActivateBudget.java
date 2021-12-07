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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testActivateBudget {

    private Owner owner;
    private ActionRequest request;
    private ActivateBudget activateBudget;

    @BeforeEach
    public void setup(){
        Owner own = new Owner("Winnie the Pooh", "Pooh", "honey");
        OwnerRepository.getOwnerRepository().addOwner(own);
        owner = OwnerRepository.getOwnerRepository().findOwner("Pooh");
        owner.setBudget(new Budget(new Date(1, 1, 2021)));

    }

    @AfterEach
    public void teardown(){
        OwnerRepository.getOwnerRepository().deleteOwner("Pooh");
    }

    @Test
    public void testActivateBudgetTrue(){
        request = new ActionRequest("Pooh", Commands.ACTIVATEBUDGET, new ArrayList<>());
        activateBudget = new ActivateBudget(request);

        ActivateBudgetResponse result = activateBudget.process();
        assertTrue(result.getResult());

    }
}

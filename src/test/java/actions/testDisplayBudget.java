package actions;

import action_request_response.*;
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
        String expected = "No Active or Existing Budget to View\n";
        assertEquals(expected, ((DisplayBudgetResponse)result).getResult());
    }

//    @Test
//    public void testInactiveBudget(){
//
//    }
//
//    @Test
//    public void testActiveBudget(){
//
//    }
}

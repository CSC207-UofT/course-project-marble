package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.CashOutResponse;
import action_request_response.Commands;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
At the moment, the only NonDepositable we have is Bond. This is why
test only utilise bonds
 */
public class testCashOut {
    private Owner owner;
    private NonDepositable investment;
    private ActionRequest request;
    private Date currentDate;
    private CashOut callAction;


    @BeforeEach
    public void setup(){
        Owner own = new Owner("John Doe", "jd", "1234");
        OwnerRepository.getOwnerRepository().addOwner(own);
        owner = OwnerRepository.getOwnerRepository().findOwner("jd");
        currentDate = new Date();
        investment = new Bond(5, 5f, 12.5, currentDate, "Bond1");
        owner.addAsset(investment);
        request = new ActionRequest("jd", Commands.CASHOUT, new ArrayList<>(List.of("Bond1")));
        callAction = new CashOut(request);
    }
    @AfterEach
    public void teardown(){
        OwnerRepository.getOwnerRepository().deleteOwner("jd");

    }

    @Test
    public void testSuccessfulCashOut(){
        ActionResponse result = callAction.process();
        assertTrue(((CashOutResponse) result).getResult());
        assertEquals(62.5, owner.getBalance());
    }

    @Test
    public void testCashOutSameNonDepositable(){
        ActionResponse result = callAction.process();
        assertTrue(((CashOutResponse) result).getResult());
        assertEquals(62.5, owner.getBalance());
        // trying to call on an action twice means putting in a new request
        // the second time you call for it
        callAction = new CashOut(request);
        result = callAction.process();
        assertFalse(((CashOutResponse) result).getResult());
        assertEquals(62.5, owner.getBalance());
    }

    @Test
    public void testCashOutNonMature(){
        Date futureDate = new Date(11, 12, 2300 + currentDate.getYear());
        investment = new Bond(5, 5f, 12.5, futureDate, "Bond2");
        request = new ActionRequest("jd", Commands.CASHOUT, new ArrayList<>(List.of("Bond2")));
        callAction = new CashOut(request);
        ActionResponse result = callAction.process();
        assertFalse(((CashOutResponse) result).getResult());
        assertEquals(0, owner.getBalance());
    }
}

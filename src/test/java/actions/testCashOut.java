package actions;

import action_request_response.ActionResponse;
import action_request_response.CashOutRequest;
import action_request_response.CashOutResponse;
import entity.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
At the moment, the only NonDepositable we have is Bond. This is why
test only utilise bonds
 */
public class testCashOut {
    private Owner owner;
    private NonDepositable investment;
    private CashOutRequest request;
    private CashOut callAction;


    @BeforeEach
    public void setup(){
        Owner own = new Owner("John Doe", "jd", "1234");
        OwnerRepository.getOwnerRepository().addOwner(own);
        owner = OwnerRepository.getOwnerRepository().findOwner("jd");
        Date dateOfMaturity = new Date();
        investment = new Bond(5, 5f, 12.5, dateOfMaturity);
        request = new CashOutRequest("jd", investment);
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
        request = new CashOutRequest("jd", investment);
        callAction = new CashOut(request);
        result = callAction.process();
        assertFalse(((CashOutResponse) result).getResult());
        assertEquals(62.5, owner.getBalance());
    }

    @Test
    public void testCashOutNonMature(){
        Date fakeDate = new Date(11, 12, 2300);
        investment = new Bond(5, 5f, 12.5, fakeDate);
        request = new CashOutRequest("jd", investment);
        callAction = new CashOut(request);
        ActionResponse result = callAction.process();
        assertFalse(((CashOutResponse) result).getResult());
        assertEquals(0, owner.getBalance());
    }
}

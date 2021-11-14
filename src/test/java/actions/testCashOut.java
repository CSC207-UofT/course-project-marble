package actions;

import action_request_response.ActionResponse;
import action_request_response.CashOutRequest;
import action_request_response.CashOutResponse;
import entity.Bond;
import entity.Date;
import entity.NonDepositable;
import entity.Owner;

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
        owner = new Owner("John Doe", "JDoe22", "123$$");
        Date dateOfMaturity = new Date();
        investment = new Bond(5, 5f, 12.5, dateOfMaturity);
        request = new CashOutRequest(owner, investment);
        callAction = new CashOut(request);
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
        result = callAction.process();
        assertFalse(((CashOutResponse) result).getResult());
    }

    @Test
    public void testCashOutNonMature(){
        Date fakeDate = new Date(11, 12, 2300);
        investment = new Bond(5, 5f, 12.5, fakeDate);
        request = new CashOutRequest(owner, investment);
        callAction = new CashOut(request);
        ActionResponse result = callAction.process();
        assertFalse(((CashOutResponse) result).getResult());
    }
}

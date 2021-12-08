package actions;
import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.TransferResponse;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class testTransfer {
    private Owner user;
    private Savings account1;

    @BeforeEach
    public void setup() {
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        user = OwnerRepository.getOwnerRepository().findOwner("jd_123");
        account1 = new Savings(2.4, "Savings1");
        user.addAsset(account1);
        user.setBalance(1000);
        account1.setBalance(2000);
    }

    @AfterEach
    public void teardown() {
        OwnerRepository.getOwnerRepository().deleteOwner("jd_123");
    }


    @Test
    public void testTransferBalanceSuccess(){
        ActionRequest transferRequest = new ActionRequest("jd_123", Commands.TRANSFER,
                new ArrayList<>(List.of("200.0", "Savings1")));
        Transfer transfer = new Transfer(transferRequest);
        TransferResponse response = (TransferResponse) transfer.process();
        assertTrue(response.getResult());
        assertEquals(800, user.getBalance());
        assertEquals(2200, account1.getBalance());
    }

    @Test
    public void testTransferBalanceFail(){
        ActionRequest transferRequest = new ActionRequest("jd_123", Commands.TRANSFER,
                new ArrayList<>(List.of("2002.0", "Savings1")));
        Transfer transfer = new Transfer(transferRequest);
        TransferResponse response = (TransferResponse) transfer.process();
        assertFalse(response.getResult());
        assertEquals(1000, user.getBalance());
        assertEquals(2000, account1.getBalance());
    }
}

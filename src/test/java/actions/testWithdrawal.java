package actions;

import action_request_response.WithdrawalResponse;
import entity.Owner;
import entity.OwnerRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testWithdrawal {
    private Owner user;

    @BeforeEach
    public void setup() {
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        user = OwnerRepository.getOwnerRepository().findOwner("jd_123");
        user.setBalance(1000);
    }

    @AfterEach
    public void teardown() {
        OwnerRepository.getOwnerRepository().deleteOwner("jd_123");
    }

    @Test
    public void testWithdrawSuccess(){
        WithdrawalRequest withdrawRequest = new WithdrawalRequest("jd_123", 200.0, "Bill", "Electricity");
        Withdrawal withdraw = new Withdrawal(withdrawRequest);
        WithdrawalResponse response = (WithdrawalResponse) withdraw.process();
        assertEquals(800.0, user.getBalance());
        assertTrue(response.getResult());
    }

    @Test
    public void testWithdrawFailure(){
        WithdrawalRequest withdrawRequest = new WithdrawalRequest("jd_123", 2000.0, "Entertainment", "New Furniture");
        Withdrawal withdraw = new Withdrawal(withdrawRequest);
        WithdrawalResponse response = (WithdrawalResponse) withdraw.process();
        assertEquals(1000.0, user.getBalance());
        assertFalse(response.getResult());
    }
}

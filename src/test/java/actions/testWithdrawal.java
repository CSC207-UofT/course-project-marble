package actions;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.WithdrawalResponse;
import entity.Owner;
import entity.OwnerRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        ActionRequest withdrawRequest = new ActionRequest("jd_123", Commands.WITHDRAWAL, new ArrayList<>(List.of("200.0", "Bill", "Electricity")));
        Withdrawal withdraw = new Withdrawal(withdrawRequest);
        WithdrawalResponse response = (WithdrawalResponse) withdraw.process();
        assertEquals(800.0, user.getBalance());
        assertTrue(response.getResult());
    }

    @Test
    public void testWithdrawFailure(){
        ActionRequest withdrawRequest = new ActionRequest("jd_123", Commands.WITHDRAWAL, new ArrayList<>(List.of("Bill", "Electricity")));
        Withdrawal withdraw = new Withdrawal(withdrawRequest);
        WithdrawalResponse response = (WithdrawalResponse) withdraw.process();
        assertEquals(1000.0, user.getBalance());
        assertFalse(response.getResult());
    }
}

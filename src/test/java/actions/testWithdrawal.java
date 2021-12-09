package actions;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.WithdrawalResponse;
import entity.Budget;
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
    private Budget budget;

    @BeforeEach
    public void setup() {
        ActionRequest createUserRequest = new ActionRequest("jd_123", Commands.CREATEUSER,new ArrayList<>(List.of("John Doe","password")));
        CreateOwner createUser = new CreateOwner(createUserRequest);
        createUser.process();
        user = OwnerRepository.getOwnerRepository().findOwner("jd_123");
        user.setBalance(1000);
        budget = user.getBudget();

    }

    @AfterEach
    public void teardown() {
        OwnerRepository.getOwnerRepository().deleteOwner("jd_123");
    }

    @Test
    public void testWithdrawSuccess(){
        ActionRequest withdrawRequest = new ActionRequest("jd_123", Commands.WITHDRAWAL, new ArrayList<>(List.of("200.0", "Bill Payments", "Electricity")));
        Withdrawal withdraw = new Withdrawal(withdrawRequest);
        WithdrawalResponse response = (WithdrawalResponse) withdraw.process();
        assertEquals(800.0, user.getBalance());
        assertTrue(response.getResult());
    }

    @Test
    public void testWithdrawFailure(){
        ActionRequest withdrawRequest = new ActionRequest("jd_123", Commands.WITHDRAWAL, new ArrayList<>(List.of("2000.0", "Bill Payments", "Electricity")));
        Withdrawal withdraw = new Withdrawal(withdrawRequest);
        WithdrawalResponse response = (WithdrawalResponse) withdraw.process();
        assertEquals(1000.0, user.getBalance());
        assertFalse(response.getResult());
        assertEquals(budget.getActualSpending("Bill Payments"), 0.0);
    }

    @Test
    public void testWithdrawBudget(){
        ActionRequest withdrawRequest = new ActionRequest("jd_123", Commands.WITHDRAWAL, new ArrayList<>(List.of("200.0", "Bill Payments", "Electricity")));
        Withdrawal withdraw = new Withdrawal(withdrawRequest);
        withdraw.process();
        assertEquals(budget.getActualSpending("Groceries"), 0.0);
        assertEquals(budget.getActualSpending("Bill Payments"), 200.0);
    }

    @Test
    public void testWithdrawBudgetNotActive(){
        budget.setActive(false);
        ActionRequest withdrawRequest = new ActionRequest("jd_123", Commands.WITHDRAWAL, new ArrayList<>(List.of("200.0", "Bill Payments", "Electricity")));
        Withdrawal withdraw = new Withdrawal(withdrawRequest);
        withdraw.process();
        assertEquals(budget.getActualSpending("Bill Payments"), 0.0);
    }
}

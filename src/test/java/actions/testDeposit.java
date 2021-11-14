package actions;

import action_request_response.ActionResponse;
import action_request_response.DepositRequest;
import action_request_response.DepositResponse;

import entity.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class testDeposit {
    private Owner owner;
    private DepositRequest request;
    @BeforeEach
    public void setup(){
        owner = new Owner("Oliver Twist", "OliveBoyz", "1234");
    }

    @Test
    public void testDepositSavings(){
        Savings savings = new Savings(5.5);
        request = new DepositRequest(owner, 11.50, savings);
        Deposit callDeposit = new Deposit(request);
        ActionResponse response = callDeposit.process();

        assertTrue(((DepositResponse) response).getResult());
        assertEquals(11.5, savings.getBalance());

    }

    @Test
    public void testDepositBalance(){
        request = new DepositRequest(owner, 11.5);
        Deposit callDeposit = new Deposit(request);
        ActionResponse response = callDeposit.process();

        assertTrue(((DepositResponse) response).getResult());
        assertEquals(11.50, owner.getBalance());
    }

    @Test
    public void testDepositCreditCard(){
        CreditCard creditCard = new CreditCard();
        request = new DepositRequest(owner, 11.50, creditCard);
        Deposit callDeposit = new Deposit(request);
        ActionResponse response = callDeposit.process();

        assertTrue(((DepositResponse) response).getResult());
        assertEquals(11.5, creditCard.getBalance());
    }

    @Test
    public void testDepositNegativeValue(){
        request = new DepositRequest(owner, -11.5);
        Deposit callDeposit = new Deposit(request);
        ActionResponse response = callDeposit.process();

        assertFalse(((DepositResponse) response).getResult());
        assertEquals(0.0, owner.getBalance());
    }
}

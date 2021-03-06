package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.Commands;
import action_request_response.DepositResponse;
import entity.Owner;
import entity.OwnerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class testDeposit {
    private Owner owner;
    private ActionRequest request;

    @BeforeEach
    public void setup(){
        Owner own = new Owner("Oliver Twist", "OliveBoyz", "1234");
        OwnerRepository.getOwnerRepository().addOwner(own);
        owner = OwnerRepository.getOwnerRepository().findOwner("OliveBoyz");
    }

    @AfterEach
    public void teardown(){
        OwnerRepository.getOwnerRepository().deleteOwner("OliveBoyz");

    }

    @Test
    public void testDepositBalance(){
        request = new ActionRequest("OliveBoyz", Commands.DEPOSIT, new ArrayList<>(List.of("11.5")));
        Deposit callDeposit = new Deposit(request);
        ActionResponse response = callDeposit.process();

        assertTrue(((DepositResponse) response).getResult());
        assertEquals(11.50, owner.getBalance());
    }

    @Test
    public void testDepositNegativeValue(){
        request = new ActionRequest("OliveBoyz",Commands.DEPOSIT, new ArrayList<>(List.of("-11.5")));
        Deposit callDeposit = new Deposit(request);
        ActionResponse response = callDeposit.process();

        assertFalse(((DepositResponse) response).getResult());
        assertEquals(0.0, owner.getBalance());
    }
}

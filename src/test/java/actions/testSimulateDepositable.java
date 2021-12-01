package actions;

import action_request_response.SimulateResponse;
import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSimulateDepositable {
    private Depositable assetSavings;
    private Depositable assetCreditCard;

    @BeforeEach
    public void setup(){
        assetSavings = new Savings(12.0, "Savings1");
        assetCreditCard = new CreditCard("CreditCard1");
        assetSavings.setBalance(200);
        assetCreditCard.setBalance(-100);
    }

    @Test
    public void testSavingsSimulation(){
        Date endDate = new Date(2, 1, 2022);
        SimulateDepositableRequest request = new SimulateDepositableRequest("jd_123", assetSavings, endDate);
        SimulateDepositable simulation = new SimulateDepositable(request);
        SimulateResponse response = (SimulateResponse) simulation.process();
        assertEquals(204.02, response.getResult(), 0.05);
    }

    @Test
    public void testCreditCardSimulation(){
        Date endDate = new Date(2, 1, 2022);
        SimulateDepositableRequest request = new SimulateDepositableRequest("jd_123", assetCreditCard, endDate);
        SimulateDepositable simulation = new SimulateDepositable(request);
        SimulateResponse response = (SimulateResponse) simulation.process();
        assertEquals(-103.34, response.getResult(), 0.05);
    }
}

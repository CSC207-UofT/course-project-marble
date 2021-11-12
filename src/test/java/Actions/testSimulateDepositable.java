package Actions;

import actions.SimulateDepositable;
import entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class testSimulateDepositable {
    private Date endDate; // future date
    private Depositable assetSavings;
    private Depositable assetCreditCard;

    @BeforeEach
    public void setup(){
        endDate = new Date(2, 1, 2022);
        assetSavings = new Savings(12.0);
        assetCreditCard = new CreditCard();
        assetSavings.setBalance(200);
        assetCreditCard.setBalance(-100);
    }
    @Test
    public void testSavingsSimulation(){
        SimulateDepositable simulation = new SimulateDepositable(endDate, assetSavings);
        assertEquals(204.02, simulation.getSimulatedAssetValue(), 0.05);
    }
    @Test
    public void testCreditCardSimulation(){
        SimulateDepositable simulation = new SimulateDepositable(endDate, assetCreditCard);
        assertEquals(-103.34, simulation.getSimulatedAssetValue(), 0.05);
    }
}

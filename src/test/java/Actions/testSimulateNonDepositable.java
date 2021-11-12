package Actions;

import actions.SimulateNonDepositable;
import entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class testSimulateNonDepositable {
    private Date endDateMature; // future date when asset reaches maturity
    private Date endDateImmature; // future date before asset reaches maturity
    private NonDepositable assetBond;

    @BeforeEach
    public void setup() {
        endDateImmature = new Date(7, 16, 2022);
        endDateMature = new Date(11, 1, 2021);
    }
    @Test
    public void testSimulationMature(){
        assetBond = new Bond(2, 7, 1000, endDateMature);
        SimulateNonDepositable simulation = new SimulateNonDepositable(assetBond);
        assertEquals(2000.03, simulation.getSimulatedAssetValue(), 0.05);
    }

    @Test
    public void testSimulationImmature(){
        assetBond = new Bond(2, 7, 1000, endDateImmature);
        SimulateNonDepositable simulation = new SimulateNonDepositable(assetBond);
        assertEquals(0.0, simulation.getSimulatedAssetValue(), 0.05);
    }
}


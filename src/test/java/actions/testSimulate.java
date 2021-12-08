package actions;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.SimulateResponse;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class testSimulate {

    @BeforeEach
    public void setup() {
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        Owner owner = OwnerRepository.getOwnerRepository().findOwner("jd_123");

        Date maturityDate = new Date(1, 1, 2022);

        Depositable assetSavings = new Savings(12.0, "Savings1");
        assetSavings.setBalance(200);
        Depositable assetSave = new Savings(0.12, "Bond");
        assetSave.setBalance(300);
        NonDepositable assetBond = new Bond(2, 7.0, 1000, maturityDate, "Bond1");

        owner.addAsset(assetSavings);
        owner.addAsset(assetSave);
        owner.addAsset(assetBond);
    }

    @AfterEach
    public void teardown() {
        OwnerRepository.getOwnerRepository().deleteOwner("jd_123");
    }

    @Test
    public void testSimulateOneMonthMature() {
        ActionRequest simulateRequest = new ActionRequest("jd_123", Commands.SIMULATE,
                new ArrayList<>(List.of("2022-02-01")));
        Simulate simulation = new Simulate(simulateRequest);
        SimulateResponse response = (SimulateResponse) simulation.process();
        ArrayList<Double> expected = new ArrayList<>();
        expected.add(202.0);
        expected.add(-101.66);
        expected.add(2000.03);

        for (int i = 0; i < response.getResult().size(); i++) {
            assertEquals(expected.get(i), response.getResult().get(i), 0.05);
        }
    }

    @Test
    public void testSimulateImmature() {
        ActionRequest simulateRequest = new ActionRequest("jd_123", Commands.SIMULATE,
                new ArrayList<>(List.of("2021-12-01")));
        Simulate simulation = new Simulate(simulateRequest);
        SimulateResponse response = (SimulateResponse) simulation.process();

        assertEquals(0.0, response.getResult().get(2));
    }
}

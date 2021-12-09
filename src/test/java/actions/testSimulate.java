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
        NonDepositable assetBond = new Bond(2, 7.0, 1000, maturityDate, "Bond1");
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
        expected.add(2000.0);

        assertEquals(expected.get(0), response.getResult().get(0), 0.01);
    }

    @Test
    public void testSimulateImmature() {
        ActionRequest simulateRequest = new ActionRequest("jd_123", Commands.SIMULATE,
                new ArrayList<>(List.of("2021-12-01")));
        Simulate simulation = new Simulate(simulateRequest);
        SimulateResponse response = (SimulateResponse) simulation.process();

        assertEquals(0.0, response.getResult().get(0));
    }
}

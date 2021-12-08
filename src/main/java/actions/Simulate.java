package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.SimulateResponse;
import entity.*;

import java.util.ArrayList;

public class Simulate extends Actions {
    private final Owner owner;
    private final Date endDate; // future date
    private final ArrayList<String> simulatedFinancialAssets;

    /**
     * This is a constructor method for an abstract class for simulating worth of depositable and
     * nondepositable assets.
     */
    public Simulate(ActionRequest request) {
        this.owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        ArrayList<String> userInputs = request.getUserInputs();
        this.endDate = Date.parseDate(userInputs.get(0));
        this.simulatedFinancialAssets = new ArrayList<>();
    }

    @Override
    public ActionResponse process(){
        for (FinancialAsset asset : owner.getListAssets()) {
            SimulateContext context;
            if (asset instanceof Depositable) {
                context = new SimulateContext(new DepositableSimulateStrategy((Depositable) asset, endDate));
            } else {
                context = new SimulateContext(new NonDepositableSimulatesStrategy((NonDepositable) asset, endDate));
            }
            simulatedFinancialAssets.add(asset.name + ": " + context.executeStrategy());
        }
        return new SimulateResponse(simulatedFinancialAssets);
    }
}


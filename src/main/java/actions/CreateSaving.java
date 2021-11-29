package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import entity.Owner;
import entity.OwnerRepository;
import entity.Savings;

import java.util.ArrayList;

public class CreateSaving extends Actions{
    private final String name;
    private final double interestRate;
    private final Owner owner;

    /**
     * Initializer for the class
     * @param request contains all the information a CreateBond object
     *                needs to process the User request
     */
    public CreateSaving(ActionRequest request){
        owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        ArrayList<String> userInputs = request.getUserInputs();
        name = userInputs.get(0);
        interestRate = Double.parseDouble(userInputs.get(1));
    }

    public ActionResponse process() {
        Savings saving = new Savings(interestRate, name);
        owner.addAsset(saving);
        return new ActionResponse();
    }
}

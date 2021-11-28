package actions;

import action_request_response.ActionResponse;
import entity.Owner;
import entity.OwnerRepository;
import entity.Savings;

public class CreateSaving extends Actions{
    private final String name;
    private final double interestRate;
    private final Owner owner;

    /**
     * Initializer for the class
     * @param request contains all the information a CreateBond object
     *                needs to process the User request
     */
    public CreateSaving(CreateSavingRequest request){
        owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        name = request.getName();
        interestRate = request.getInterestRate();
    }

    public ActionResponse process() {
        Savings saving = new Savings(interestRate, name);
        owner.addAsset(saving);
        return new ActionResponse();
    }
}

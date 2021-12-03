package actions;

import action_request_response.ActionResponse;
import action_request_response.CreateBondRequest;
import action_request_response.CreateBondResponse;
import entity.Bond;
import entity.Owner;
import entity.OwnerRepository;

public class CreateBond extends Actions{
        private final Bond bond;
        private final Owner owner;


        /**
         * Initializer for the class
         * @param request contains all the information a CreateBond object
         *                needs to process the User request
         */
        public CreateBond(CreateBondRequest request){
            this.owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
            bond = new Bond(request.getVolume(),
                    (float) request.getInterestRate(), request.getPricePerAsset(), request.getDateOfMaturity(), request.getName());
        }

        /**
         * Processes the request
         * @return returns a response to how the process went
         */
        @Override
        public ActionResponse process(){
            double balance = owner.getBalance();
            double priceOfBonds = bond.getTotalCost();
            if (priceOfBonds > balance){
                return new CreateBondResponse(false);
            }
            owner.setBalance(balance - priceOfBonds);
            owner.addAsset(bond);
            return new CreateBondResponse(true);
        }
}

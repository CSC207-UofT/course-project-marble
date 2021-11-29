package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.CreateBondResponse;
import entity.Bond;
import entity.Date;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;

public class CreateBond extends Actions{
//        private final Bond bond;
        private final Owner owner;
        private final String name;
        private final int volume;
        private final double interestRate;
        private final double price;
        private final Date date;


        /**
         * Initializer for the class
         * @param request contains all the information a CreateBond object
         *                needs to process the User request
         */
        public CreateBond(ActionRequest request){
            this.owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
            ArrayList<String> userInputs = request.getUserInputs();
            this.name = userInputs.get(0);
            this.interestRate = Double.parseDouble(userInputs.get(1));
            this.price = Double.parseDouble(userInputs.get(2));
            this.volume = Integer.parseInt(userInputs.get(3));
            this.date = Date.parseDate(userInputs.get(4));
        }

        /**
         * Processes the request
         * @return returns a response to how the process went
         */
        @Override
        public ActionResponse process(){
            Bond bond = new Bond(volume, interestRate, price, date, name);
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

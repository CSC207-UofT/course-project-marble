package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.TransferResponse;
import entity.*;
import entity.Record;

import java.util.ArrayList;

public class Transfer extends Actions{
    private final Owner user;
    private final Date date;
    private final Double cost;
    private final String assetName;

    public Transfer(ActionRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.date = new Date();
        ArrayList<String> userInputs = request.getUserInputs();
        this.cost = Double.parseDouble(userInputs.get(0));
        this.assetName = userInputs.get(1);
    }

    /**
     * This method transfers money from the user's balance to a Depositable account.
     * @return true if money is transferred successfully, false if money can not be transferred.
     */
    @Override
    public ActionResponse process() {
        if (this.cost <= this.user.getBalance()) {
            this.user.setBalance(this.user.getBalance() - this.cost);
            for (FinancialAsset asset: this.user.getListAssets()){
                if (asset.getName().equals(this.assetName) && asset instanceof Depositable) {
                    ((Depositable) asset).deposit(this.cost);
                }
            }
            Record withdrawal = new Record(this.cost, this.date, null,"Banking transfer");
            this.user.addRecord(withdrawal);
            return new TransferResponse(true);
        }
        return new TransferResponse(false);

    }
}

package actions;

import action_request_response.UpdateDepositableRequest;
import action_request_response.ActionResponse;
import action_request_response.UpdateDepositableResponse;
import entity.Date;
import entity.Depositable;
import entity.FinancialAsset;
import entity.OwnerRepository;

import java.util.ArrayList;

public class UpdateDepositable extends Actions{
    private ArrayList<FinancialAsset> listAssets;
    private Date date;

    public UpdateDepositable(UpdateDepositableRequest request) {
        this.listAssets = OwnerRepository.getOwnerRepository().findOwner(request.getUsername()).getListAssets();
        this.date = new Date();

    }
    /**
     * This method calculates the current balance of Depositable account.
     */
    public void valueDepositable(Depositable asset){
        int numMonth = date.monthDifference(asset.getDateCreated());
        for(int i=0; i<numMonth;i++){
            asset.addInterest();
        }
    }

    @Override
    public ActionResponse process() {
        for (FinancialAsset asset : listAssets) {
            if (asset instanceof Depositable) {
                valueDepositable((Depositable) asset);
            }
        }
        return new UpdateDepositableResponse();
    }

}

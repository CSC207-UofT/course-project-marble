package actions;
import action_request_response.ActionResponse;
import action_request_response.CashOutRequest;
import action_request_response.CashOutResponse;
import entity.FinancialAsset;
import entity.NonDepositable;
import entity.Owner;
import entity.OwnerRepository;
import java.lang.Math;
import java.util.ArrayList;

/**
 * Class is responsible for handling a request from the User
 * to sell/"cash out" a NonDepositable investment and put the value
 * of the investment into their account Balance
 *
 * Note that some investments are time based and the class can deny
 * the request to cash them out
 */
public class CashOut extends Actions{
    private final Owner owner;
    private NonDepositable investment;


    /**
     * Initializer for the class
     * @param request contains all the information a CashOut object
     *                needs to process the User request
     */
    public CashOut(CashOutRequest request){
        this.owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        String name = request.getName();
        ArrayList<FinancialAsset> listAssets = owner.getListAssets();
        for (FinancialAsset asset:listAssets) {
            if (asset instanceof NonDepositable) {
                if (name.equals((asset).getName())) {
                    investment = (NonDepositable) asset;
                    return;
                }
            }
        }
        investment = null;

    }

    /**
     * Processes the request
     * @return returns a response to how the process went
     */
    @Override
    public ActionResponse process(){
        if (investment == null){
            return new CashOutResponse(false);
        }
        double value = investment.cashOut();
        if (value == -1){
            return new CashOutResponse(false);
        } else{
            value = Math.round(value * 100.0) / 100.0;
            double currentAmount = owner.getBalance();
            owner.setBalance(currentAmount + value);
            return new CashOutResponse(true);
        }
    }
}
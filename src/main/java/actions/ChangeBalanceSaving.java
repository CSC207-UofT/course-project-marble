package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.DepositSavingResponse;
import entity.FinancialAsset;
import entity.Owner;
import entity.OwnerRepository;
import entity.Savings;

import java.util.ArrayList;
import java.util.Objects;

public class ChangeBalanceSaving extends Actions {
    private Savings savings;
    private final Owner owner;
    private double amount;

    public ChangeBalanceSaving(ActionRequest request){
        owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        ArrayList<String> userInputs = request.getUserInputs();
        String name = userInputs.get(0);
        amount = Double.parseDouble(userInputs.get(1));
        ArrayList<FinancialAsset> listAssets = owner.getListAssets();
        for (FinancialAsset asset: listAssets){
            if (asset instanceof Savings && Objects.equals(asset.getName(), name)){
                savings = (Savings) asset;
                break;
            }

        }
    }
    @Override
    public ActionResponse process(){
        if (savings == null || owner.getBalance() - amount < 0 || savings.getValue() + amount < 0) {
            return new DepositSavingResponse(false);
        }
        double temp = owner.getBalance();
        owner.setBalance(temp - amount);
        temp = savings.getBalance();
        savings.setBalance(temp + amount);
        return new DepositSavingResponse(true);
    }
}

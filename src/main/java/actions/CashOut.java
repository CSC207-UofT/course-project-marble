package actions;
import action_request_response.ActionResponse;
import action_request_response.CashOutRequest;
import action_request_response.CashOutResponse;
import entity.NonDepositable;
import entity.Owner;
import entity.OwnerRepository;
import java.lang.Math;

public class CashOut extends Actions{
    private final Owner owner;
    private final NonDepositable investment;

    public CashOut(CashOutRequest request){
        this.owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.investment = request.getInvestment();
    }

    @Override
    public ActionResponse process(){
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
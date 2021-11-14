package action_request_response;

import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;

public class CompareBudgetRequest extends ActionRequest{
    private final Budget budget;
    private final double total;
    private final ArrayList<String> ruleBudget;

    public CompareBudgetRequest(String username){
        super(username);
        Owner owner = OwnerRepository.getOwnerRepository().findOwner(username);
        budget = owner.getBudget();
        if (!(budget == null)) {
            total = budget.getTotalBudget();
            ruleBudget = calculateRuleAmount(total);
        } else {
            total = -1;
            ruleBudget = new ArrayList<>();
        }
    }

    public Budget getBudget() { return budget; }

    public double getTotal() { return total; }

    public ArrayList<String> getRuleBudget() { return ruleBudget; }

    private ArrayList<String> calculateRuleAmount(double total){
        ArrayList<String> values = new ArrayList<>();
        double temp = (double)Math.round(total*0.5*100)/100;
        values.add(Double.toString(temp));
        temp = (double)Math.round(total*0.3*100)/100;
        values.add(Double.toString(temp));
        temp = (double)Math.round(total*0.2*100)/100;
        values.add(Double.toString(temp));
        return values;
    }

}

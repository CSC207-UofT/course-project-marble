package server;


import action_request_response.*;
import actions.*;

public class ActionFactory {
    public Actions getAction(ActionRequest request) {
        if (request instanceof LoginRequest) {
            return new CheckLogin((LoginRequest) request);
        } else if (request instanceof CreateUserRequest) {
            return new CreateOwner((CreateUserRequest) request);
        } else if (request instanceof CashOutRequest){
            return new CashOut((CashOutRequest) request);
        } else if (request instanceof DepositRequest){
            return new Deposit((DepositRequest) request);
        } else if (request instanceof OwnerInfoRequest){
            return new OwnerInfo((OwnerInfoRequest) request);
        } else if (request instanceof CompareBudgetRequest) {
            return new CompareBudget((CompareBudgetRequest) request);
        } else if (request instanceof AddExpenseRequest){
            return new AddExpense((AddExpenseRequest) request);
        } else{
            return null;
        }
    }
}

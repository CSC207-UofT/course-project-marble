package server;


import action_request_response.*;
import actions.*;

public class ActionFactory {
    public Actions getAction(ActionRequest request) {
        if (request instanceof LoginRequest) {
            return new CheckLogin((LoginRequest) request);
        } else if (request instanceof CreateUserRequest) {
            return new CreateOwner((CreateUserRequest) request);
        } else if (request instanceof OwnerInfoRequest){
            return new OwnerInfo((OwnerInfoRequest) request);
        } else if (request instanceof WithdrawalRequest){
            return new Withdrawal((WithdrawalRequest) request);
        } else if (request instanceof DisplayWithdrawalRecordRequest){
            return new DisplayWithdrawalRecord((DisplayWithdrawalRecordRequest) request);
        } else if (request instanceof DepositRequest){
            return new Deposit((DepositRequest) request);
        } else if (request instanceof DisplayDepositRecordRequest){
            return new DisplayDepositRecord((DisplayDepositRecordRequest) request);
        } else if (request instanceof UpdateDepositableRequest){
            return new UpdateDepositable((UpdateDepositableRequest) request);
        } else if (request instanceof ViewInvestmentsRequest){
            return new ViewInvestments((ViewInvestmentsRequest) request);
        } else if (request instanceof CashOutRequest){
            return new CashOut((CashOutRequest) request);
        } else{
            return null;
        }
    }
}

//else if (request instanceof CompareBudgetRequest) {
//        return new CompareBudget((CompareBudgetRequest) request);
//        } else if (request instanceof AddExpenseRequest){
//        return new AddExpense((AddExpenseRequest) request);
//        }
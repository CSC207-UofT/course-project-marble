package server;


import action_request_response.*;
import actions.*;

public class ActionFactory {
    public Actions getAction(ActionRequest request) {
        Commands command = request.getCommand();
        switch (command) {
            case LOGIN:
                return new CheckLogin(request);
            case CREATEUSER:
                return new CreateOwner(request);
            case OWNERINFO:
                return new OwnerInfo(request);
            case WITHDRAWAL:
                return new Withdrawal(request);
            case DEPOSIT:
                return new Deposit(request);
            case DISPLAYWITHDRAWALRECORD:
                return new DisplayWithdrawalRecord(request);
            case DISPLAYDEPOSITRECCORD:
                return new DisplayDepositRecord(request);
            case CREATESAVINGS:
                return new CreateSaving(request);
            case CREATEBOND:
                return new CreateBond(request);
            case UPDATEDEPOSITABLE:
                return new UpdateDepositable(request);
            case VIEWINVESTMENTS:
                return new ViewInvestments(request);
            case CASHOUT:
                return new CashOut(request);
            case DEPOSITSAVINGS:
                return new ChangeBalanceSaving(request);
            case ADJUSTBUDGET:
                return new AdjustBudget(request);
            case CALCULATEREMAININGBUDGET:
                return new CalculateRemainingBudget(request);
            case COMPAREBUDGET:
                return new CompareBudget(request);
            case RESETBUDGET:
                return new ResetBudget(request);
            case VIEWBUDGETPERFORMANCE:
                return new ViewBudgetPerformance(request);
            case DISPLAYBUDGET:
                return new DisplayBudget(request);
            case SIMULATE:
                return new Simulate(request);
        }
        return null;
    }
}

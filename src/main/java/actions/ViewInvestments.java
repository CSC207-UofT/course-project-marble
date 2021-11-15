package actions;

import action_request_response.ActionResponse;
import action_request_response.ViewInvestmentsRequest;
import action_request_response.ViewInvestmentsResponse;
import entity.*;

import java.util.ArrayList;

public class ViewInvestments extends Actions{
    private final ArrayList<FinancialAsset> listAssets;

    public ViewInvestments(Depositable account){
        this.account = account;
    }

    /**
     * This method displays information on the Depositable accounts.
     * @return String of Depositable accounts.
     */
    @Override
    public ActionResponse process() {
        return new ViewInvestmentsResponse(listAssets.toString());
    }
}

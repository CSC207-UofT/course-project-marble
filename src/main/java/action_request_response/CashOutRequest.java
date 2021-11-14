package action_request_response;

import entity.NonDepositable;

/**
 * Class is responsible for containing the information CashOut
 * uses to process a CashOut request
 */
public class CashOutRequest extends ActionRequest{
    private final NonDepositable investment;

    /** Initializer
     *
     * @param username username attached to the Owner object request is for
     * @param investment NonDepositable object request is trying to cash out
     */
    public CashOutRequest(String username, NonDepositable investment){
        super(username);
        this.investment = investment;
    }


    public NonDepositable getInvestment(){ return investment; }
}

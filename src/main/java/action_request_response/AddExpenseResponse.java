package action_request_response;

/**
 * Class is responsible to keeping the information on how
 * AddExpense processed the data (did it go through/"successfully added")
 */
public class AddExpenseResponse extends ActionResponse {
    private final boolean result;

    /**
     * Initializer
     *
     * @param result whether the expense was successfully added (true)
     *               or not (false)
     */
    public AddExpenseResponse(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }
}

package action_request_response;

public class LoginResponse extends ActionResponse{
    private final boolean result;

    /**
     * Constructor that creates an instance of LoginResponse given a boolean result
     *
     * @param result boolean result from the related use case that generates this LoginResponse
     */
    public LoginResponse(boolean result) {
        this.result = result;
    }

    /**
     * Getter method for result in LoginResponse
     *
     * @return a boolean result
     */
    public boolean getResult() {
        return this.result;
    }
}

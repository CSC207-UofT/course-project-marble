package action_request_response;

public class CreateUserResponse extends ActionResponse {
    private final boolean result;

    /**
     * Constructor that creates an instance of CreateUserResponse given a boolean result
     *
     * @param result boolean result from the related use case that generates this CreateUserResponse
     */
    public CreateUserResponse(boolean result) {
        this.result = result;
    }

    /**
     * Getter method for result in CreateUserResponse
     *
     * @return a boolean result
     */
    public boolean getResult() {
        return this.result;
    }
}

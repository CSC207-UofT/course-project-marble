package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.OwnerInfoResponse;
import entity.Owner;
import entity.OwnerRepository;

/**
 * Class is responsible for returning a String acting as a
 * "User Profile" for the User to view
 *
 */
public class OwnerInfo extends Actions{
    private final Owner owner;
    /**initializer for the class
     *
     * @param request contains the needed information the class
     *                object will process
     */
    public OwnerInfo(ActionRequest request){
        owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
    }

    /**
     * Processes the request
     * @return the response containing the String that will be
     * displayed and veiwed
     */
    @Override
    public ActionResponse process(){
        return new OwnerInfoResponse(owner.toString());
    }

}

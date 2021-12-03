package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;

public class OwnerInfo {
    public ActionRequest ownerInfo(String username){
      return  new ActionRequest(username, Commands.OWNERINFO, new ArrayList<>());
    }
}

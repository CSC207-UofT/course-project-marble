package actions;

import action_request_response.ActionResponse;
import action_request_response.StoreDataInJsonRequest;
import action_request_response.StoreDataInJsonResponse;
import entity.OwnerRepository;
import server.JSONTranslator;

import java.io.File;
import java.io.IOException;

public class StoreDataJson extends Actions{
    private File file;
    private JSONTranslator jsonT;
    private String fileName;

    public StoreDataJson(StoreDataInJsonRequest request) {
        fileName = request.getUsername();
        file = new File(fileName);
        jsonT = new JSONTranslator();
    }

    public ActionResponse process(){
        OwnerRepository ownerRepo = OwnerRepository.getOwnerRepository();
        try {
            jsonT.writeToJSON(ownerRepo, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new StoreDataInJsonResponse(false);
        }
        return new StoreDataInJsonResponse(true);
    }
}

package actions;

import action_request_response.ActionResponse;
import action_request_response.StoreDataInJsonResponse;
import entity.OwnerRepository;
import server.JSONTranslator;

import java.io.File;
import java.io.IOException;

public class StoreDataJson extends Actions{
    private final JSONTranslator jsonT;
    private final String fileName;

    /**
     * Initializes the filename where the data will be stored, the file where it will be stored, and the translator
     * that will turn a java obj into json and vice versa
     *
     * @param fileName file name to store to
     */
    public StoreDataJson(String fileName) {
        this.fileName =  fileName;
        File file = new File(fileName);
        this.jsonT = new JSONTranslator();
    }

    /**
     * tries to write the data to the file and if the process occurs without error return true.
     * @return boolean - if process went without error or not
     */
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

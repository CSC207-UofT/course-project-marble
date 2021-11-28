package actions;
import action_request_response.ActionResponse;
import action_request_response.DisplayWithdrawalRecordResponse;
import entity.*;
import entity.Record;

import java.util.ArrayList;

public class DisplayWithdrawalRecord extends Actions{
    private final Owner user;

    public DisplayWithdrawalRecord(DisplayWithdrawalRecordRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
    }

    /**
     * This method returns an action response of the users withdrawal record.
     */
    @Override
    public ActionResponse process(){
        ArrayList<Record> withdrawnRecord = new ArrayList<>();
        for (int i = 0; i < user.getListRecord().size(); i++){
            if (user.getListRecord().get(i).getAmount() < 0) {
                withdrawnRecord.add(user.getListRecord().get(i));
            }
        }
        return new DisplayWithdrawalRecordResponse(withdrawnRecord.toString());
    }
}


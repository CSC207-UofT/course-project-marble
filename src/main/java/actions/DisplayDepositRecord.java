package actions;

import action_request_response.ActionResponse;
import action_request_response.DisplayDepositRecordResponse;
import entity.OwnerRepository;
import entity.Record;
import entity.Owner;

import java.util.ArrayList;

public class DisplayDepositRecord extends Actions {
    private final Owner user;

    public DisplayDepositRecord(DisplayDepositRecordRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
    }

    /**
     * This method returns an action response of the deposits record.
     */
    @Override
    public ActionResponse process(){
        ArrayList<Record> depositRecord = new ArrayList<>();
        for (int i = 0; i < user.getListRecord().size(); i++){
            if (user.getListRecord().get(i).getAmount() >= 0) {
                depositRecord.add(user.getListRecord().get(i));
            }
        }
        return new DisplayDepositRecordResponse(depositRecord.toString());
    }
}

package actions;


import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.DisplayDepositRecordResponse;
import entity.Date;
import entity.Owner;
import entity.OwnerRepository;
import entity.Record;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDisplayDepositRecord {
    @BeforeEach
    public void setup() {
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        Owner user = OwnerRepository.getOwnerRepository().findOwner("jd_123");
        Record r1 = new Record(200, new Date(2, 1, 2021), "Bills", "Electricity Bill");
        Record r2 = new Record(-400, new Date(4, 1, 2021), "Bills", "Mortgage");
        user.addRecord(r1);
        user.addRecord(r2);
    }

    //TODO: Make test

    @AfterEach
    public void teardown() {
        OwnerRepository.getOwnerRepository().deleteOwner("jd_123");
    }


    @Test
    public void testDisplayDepositRecordSuccess() {
        ActionRequest request = new ActionRequest("jd_123", Commands.DISPLAYDEPOSITRECCORD, new ArrayList<>());
        DisplayDepositRecord depositRecord = new DisplayDepositRecord(request);
        DisplayDepositRecordResponse response = (DisplayDepositRecordResponse) depositRecord.process();
        ArrayList<Record> expected = new ArrayList<>();
        expected.add(new Record(200, new Date(2, 1, 2021), "Bills", "Electricity Bill"));
        assertEquals(expected.toString(), response.getResult());
    }
}


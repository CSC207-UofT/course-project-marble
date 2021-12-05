package actions;

import action_request_response.DisplayDepositRecordRequest;
import action_request_response.DisplayDepositRecordResponse;
import entity.Date;
import entity.Owner;
import entity.OwnerRepository;
import entity.Record;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class testDisplayDepositRecord {
    @BeforeEach
    public void setup() {
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        Owner user = OwnerRepository.getOwnerRepository().findOwner("jd_123");
        user.addRecord(new Record(200, new Date(2, 1, 2021), "Bills", "Electricity Bill"));
        user.addRecord(new Record(-400, new Date(4, 1, 2021), "Bills", "Mortgage"));
    }

    @AfterEach
    public void teardown() {
        OwnerRepository.getOwnerRepository().deleteOwner("jd_123");
    }

    @Test
    public void testDisplayDepositRecordSuccess() {
        DisplayDepositRecordRequest request = new DisplayDepositRecordRequest("jd_123");
        DisplayDepositRecord depositRecord = new DisplayDepositRecord(request);
        DisplayDepositRecordResponse response = (DisplayDepositRecordResponse) depositRecord.process();
        ArrayList<Record> expected = new ArrayList<>();
        expected.add(new Record(200, new Date(2, 1, 2021), "Bills", "Electricity Bill"));
        assertEquals(expected.toString(), response.getResult());
    }
}

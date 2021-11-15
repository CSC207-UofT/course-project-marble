package actions;

import action_request_response.DisplayWithdrawalRecordRequest;
import action_request_response.DisplayWithdrawalRecordResponse;
import entity.Date;
import entity.Owner;
import entity.OwnerRepository;
import entity.Record;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class testDisplayWithdrawalRecord {
    @BeforeEach
    public void setup() {
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        Owner user = OwnerRepository.getOwnerRepository().findOwner("jd_123");
        Record r1 = new Record(200, new Date(2, 1, 2021), "Bills", "Electricity Bill");
        Record r2 = new Record(-400, new Date(4, 1, 2021), "Bills", "Mortgage");
        user.addRecord(r1);
        user.addRecord(r2);
    }

    @AfterEach
    public void teardown() {
        OwnerRepository.getOwnerRepository().deleteOwner("jd_123");
    }

    @Test
    public void testDisplayWithdrawalRecordSuccess() {
        DisplayWithdrawalRecordRequest request = new DisplayWithdrawalRecordRequest("jd_123");
        DisplayWithdrawalRecord withdrawalRecord = new DisplayWithdrawalRecord(request);
        DisplayWithdrawalRecordResponse response = (DisplayWithdrawalRecordResponse) withdrawalRecord.process();
        ArrayList<Record> expected = new ArrayList<>();
        expected.add(new Record(-400, new Date(4, 1, 2021), "Bills", "Mortgage"));
        assertEquals(expected.toString(), response.getResult());
    }
}
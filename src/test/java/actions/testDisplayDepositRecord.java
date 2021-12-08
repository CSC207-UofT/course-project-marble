package actions;

import entity.Date;
import entity.Owner;
import entity.OwnerRepository;
import entity.Record;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class testDisplayDepositRecord {
    @BeforeEach
    public void setup() {
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        Owner user = OwnerRepository.getOwnerRepository().findOwner("jd_123");
        user.addRecord(new Record(200, new Date(2, 1, 2021), "Bills", "Electricity Bill"));
        user.addRecord(new Record(-400, new Date(4, 1, 2021), "Bills", "Mortgage"));
    }

    //TODO: Make test

    @AfterEach
    public void teardown() {
        OwnerRepository.getOwnerRepository().deleteOwner("jd_123");
    }
}

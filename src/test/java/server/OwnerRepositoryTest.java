package server;

import entity.Owner;
import org.junit.jupiter.api.Test;
import server.OwnerRepository;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OwnerRepositoryTest {

    private OwnerRepository ownerRepo;

    @Test
    void createOwner_OwnerExists() {
        this.ownerRepo = new OwnerRepository();
        ownerRepo.createOwner("Ruiting", "rtc", "abc");
        assertFalse(ownerRepo.createOwner("Ruiting", "rtc", "abc"));
    }

    @Test
    void createOwner_OwnerDoesNotExist() {
        this.ownerRepo = new OwnerRepository();
        assertTrue(ownerRepo.createOwner("Ruiting", "rtc", "abc"));
    }

    @Test
    void findOwner() {
    }

    @Test
    void getOwners() {
    }
}
package entity;

import server.JSONTranslator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;

public class OwnerRepository {
    private final HashMap<String, Owner> listOfOwners; // <String username, Owner Object>
    static OwnerRepository ownerRepository;

    /**
     * Add reading txt file first, then use those info to create a list of all accountIDs so it's easier to create
     * unique account later.
     */
    private OwnerRepository() {
        this.listOfOwners = new HashMap<>();
    }

    /**
     * @return a new ownerRepository is there does not already exist one, otherwise return the ownerRepository that
     * already exits
     */
    public static OwnerRepository getOwnerRepository() {
        if (ownerRepository == null) {
            if (new File("OwnerRepo.json").exists()) {
                try {
                    JSONTranslator jsonT = new JSONTranslator();
                    ownerRepository = (OwnerRepository) jsonT.readFromJSON(OwnerRepository.class, "OwnerRepo.json");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                ownerRepository = new OwnerRepository();
            }
        }
        return ownerRepository;
    }


    /**
     * getOwners is a method that Actions calls to return a Iterator of the Owners stored in listOfOwners
     *
     * @return Iterator of the Owners
     */
    public Iterator<Owner> getOwners() {
        return listOfOwners.values().iterator();
    }

    /**
     * Adds an Owner to the listOfOwners
     *
     * @param owner to be added to listOfOwners
     * @return true if the Owner addition is successful, else false.
     */
    public boolean addOwner(Owner owner) {
        if (listOfOwners.containsKey(owner.getUserName())) {
            return false;
        }
        listOfOwners.put(owner.getUserName(), owner);
        return true;
    }

    /**
     * @param username of the Owner
     * @return an Owner object of the given username
     */
    public Owner findOwner(String username) {
        return this.listOfOwners.get(username);
    }

    /**
     * @param username of the Owner
     * @return whether the Owner is deleted successfully
     */
    public boolean deleteOwner(String username) {
        if (listOfOwners.containsKey(username)) {
            listOfOwners.remove(username);
            return true;
        }
        return false;
    }


}

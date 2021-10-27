package server;

import entity.Owner;

import java.util.HashMap;
import java.util.*;

public class OwnerRepository {
    private final HashMap<String, Owner> listOfOwners; // <String username, Owner Object>
    static OwnerRepository ownerRepository;

    /**
     * TODO: read text file implementation needs to be added.
     * Add reading txt file first, then use those info to create a list of all accountIDs so it's easier to create
     * unique account later.
     */
    private OwnerRepository() {
        this.listOfOwners = new HashMap<>();
       listOfOwners.put("rtc", new Owner("Ruiting", "rtc", "abc")); // test case
    }

    /**
     *
     * @return a new ownerRepository is there does not already exist one, otherwise return the ownerRepository that
     * already exits
     */
    public static OwnerRepository getOwnerRepository() {
        if (ownerRepository == null) {
            ownerRepository = new OwnerRepository();
        }
        return ownerRepository;
    }

    /**
     * getOwners is a method that Actions calls to return a Iterator of the Owners stored in listOfOwners
     * @return Iterator of the Owners
     */
    public Iterator<Owner> getOwners() {
        return listOfOwners.values().iterator();
    }

    /**
     * Call the Owner constructor, creates an Owner object.
     * @return true if the Owner creation is successful, else false.
     */
    public boolean addOwner(Owner owner){
        if(listOfOwners.containsKey(owner.getUsername())){
            return false;
        }
        listOfOwners.put(owner.getUsername(), owner);
        return true;
    }

    /**
     *
     * @param username of the Owner
     * @return an Owner object of the given username
     */
    public Owner findOwner(String username) {
        return this.listOfOwners.get(username);
    }

    /**
     *
     * @param username of the Owner
     * @return whether the Owner is deleted successfully
     */
    public boolean deleteOwner(String username) {
        if(listOfOwners.containsKey(username)){
            listOfOwners.remove(username);
            return true;
        }
        return false;
    }


}

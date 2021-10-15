package server;

import entity.Owner;

import java.util.HashMap;
import java.util.*;

public class OwnerRepository {
    private final HashMap<String, Owner> listOfOwners; // <String username, Owner Object>


    /**
     * TODO: read text file implementation needs to be added.
     * Add reading txt file first, then use those info to create a list of all accountIDs so it's easier to create
     * unique account later.
     */
    public OwnerRepository(){
        this.listOfOwners = new HashMap<String, Owner>();
//        listOfOwners.put("rtc", new Owner("Ruiting", "rtc", "abc")); // test case
    }


    /**
     * Call the Owner constructor, creates an Owner object.
     * @return true if the Owner creation is successful, else false.
     */
    public boolean createOwner(String fullName, String username, String password){
        if(listOfOwners.containsKey(username)){
            return false;
        }
        Owner user = new Owner(fullName, username, password);
        listOfOwners.put(username, user);
        return true;
    }

    public Owner findOwner(String username){
        return this.listOfOwners.get(username);
    }

    /**
     * getOwners is a method that Actions calls to return a Iterator of the Owners stored in listOfOwners
     * @return Iterator of the Owners
     */
    public Iterator getOwners() {
        return listOfOwners.values().iterator();
    }

}

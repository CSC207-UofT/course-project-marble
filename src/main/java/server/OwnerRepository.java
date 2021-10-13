package server;

import entity.Owner;

import java.util.HashMap;

public class OwnerRepository {
    private HashMap<String, Owner> listOfOwners; // <String username, Owner Object>


    /**
     * TODO: read text file implementation needs to be added.
     * Add reading txt file first, then use those info to create a list of all accountIDs so it's easier to create
     * unique account later.
     */
    public OwnerRepository(){
        this.listOfOwners = new HashMap<String, Owner>();
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
     * loginCheck is a method that Driver calls to check if the username and the password matches with the data
     * stored here on OwnerRepository. It'll return True if the credential matches, otherwise false (e.g. wrong
     * password or user does not exist).
     * @param username checks with a list of Owner objects and see if the username matches with any of them.
     * @param password if the username matches, check if the password matches as well.
     * @return true if the password matches, return false if not
     */
    public boolean loginCheck(String username, String password){
        for(String key : listOfOwners.keySet()){
            if(username.equals(key)){
                return listOfOwners.get(key).comparePassword(password);
            }
        }
        return false;
    }
}

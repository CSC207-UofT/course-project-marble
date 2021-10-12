package entity;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class OwnerRepository {
    /**
     *
     */
    private HashMap<String, Owner> listOfOwners;

    /**
     *
     */
    public OwnerRepository(){
        // Read a txt file to initialize all the owners and their accounts
    }


    public boolean addOwner(){
        return true;
    }

    /**
     * loginCheck is a method that Driver calls to check if the username and the password matches with the data
     * stored here on OwnerRepository. It'll return True if the credential matches, otherwise false (e.g. wrong
     * password or user does not exist).
     * @param username checks with a list of Owner objects and see if the username matches with any of them.
     * @param password if the username matches, check if the password matches as well.
     * @return true if the password matches, return false if not
     */
    public boolean loginCheck(String username, String password) throws NoSuchAlgorithmException {
        for(String key : listOfOwners.keySet()){
            if(username.equals(key)){
                return listOfOwners.get(key).comparePassword(password);
            }
        }
        return false;
    }
}

package entity;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;

public class Owner {
    private final String fullName;
    private final String username;
    private final byte[] password;
    private HashMap<String, Account> Accounts;


    /**
     * TODO: read text file implementation needs to be added.
     */
    public Owner(){
        this.fullName = null;
        this.password = null;
        this.username = null;
    }

    public boolean createAccount(String accountType){
        return false;
    }

    /**
     * This function comparePasswords, hashes the parameter inputPassword and
     * compare it with the Owner's hashed password.
     * @param inputPassword the password a user inputs is compared against the actual password, "hashed" comparison
     *                      still needs to be implemented
     * @return true if the password matches, else return false
     */
    public boolean comparePassword(String inputPassword){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md != null;
        byte[] inputPasswordHashed = md.digest(inputPassword.getBytes(StandardCharsets.UTF_8));

        if (this.password != null) {
            return Arrays.equals(this.password, inputPasswordHashed);
        }
        return false;
    }
}

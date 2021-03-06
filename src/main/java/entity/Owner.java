package entity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Owner {
    private final String fullName;
    private final String userName;
    private final byte[] password;
    private double balance;
    private Budget budget;
    private final ArrayList<FinancialAsset> listAssets;
    private final ArrayList<Record> listRecord;
    private final HashMap<String, String> budgetHistory;



    /**
     * This is a constructor method to create an Owner object. Basically when this is called, a new Owner object is
     * created. Whether if it's from reading the backup txt files or called to create a new owner.
     *
     * @param fullName The full name of the user is stored here.
     * @param username The username that the person decided to use and to login is stored here.
     * @param password The password
     */
    public Owner(String fullName, String username, String password) {
        this.fullName = fullName;
        this.userName = username;
        this.listRecord = new ArrayList<>();
        this.budgetHistory = new HashMap<>();

        this.balance = 0;
        this.budget = null;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md != null;
        this.password = md.digest(password.getBytes(StandardCharsets.UTF_8));
        listAssets = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User Profile:\nName: " + this.fullName + "\nUsername: " +
                this.userName + "\nBalance: $" + this.balance + "\n";
    }

    public String getName() {
        return this.fullName;
    }

    public String getUserName() {
        return this.userName;
    }

    public ArrayList<Record> getListRecord() {
        return this.listRecord;
    }


    public void addRecord(Record newRecord) {
        this.listRecord.add(newRecord);
    }

    public void addAsset(FinancialAsset newAsset) {
        this.listAssets.add(newAsset);
    }

    public ArrayList<FinancialAsset> getListAssets() {
        return listAssets;
    }

    public void addBudgetHistory(Date date, String newBudget){this.budgetHistory.put(date.toString(),newBudget);}

    public HashMap<String, String> getBudgetHistory(){return this.budgetHistory;}

    /**
     * setBalance is to get owner's balance. Work with getBalance() when you want to adjust the balance.
     * This means there would be no increaseBalance or decreaseBalance, and should instead use
     * getBalance and setBalance by the Actions package.
     *
     * @param amount the amount that you're going to set the balance to
     */
    public void setBalance(double amount) {
        this.balance = (double) Math.round(amount * 100) / 100;
    }

    public double getBalance() {
        return this.balance;
    }

    /**
     * This method will store the Budget object that is created in the Action class.
     * Budget object is/should be created and customized under Actions using Budget's methods.
     *
     * @param budget       the date when this budget starts
     */
    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    /**
     * This method will get the Budget object of the Owner
     *
     * @return Budget object that can be used to get various information, if budget has not been set, return null
     */
    public Budget getBudget() {
        return this.budget;
    }

    /**
     * This function comparePasswords, hashes the parameter inputPassword and
     * compare it with the Owner's hashed password.
     *
     * @param inputPassword the password a user inputs is compared against the actual password, "hashed" comparison
     *                      still needs to be implemented
     * @return true if the password matches, else return false
     */
    public boolean comparePassword(String inputPassword) {
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


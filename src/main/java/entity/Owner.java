package entity;

import java.util.HashMap;

public class Owner {
    private final String name;
    private final String ID;
    private final String password;
    private HashMap<String, Account> Accounts;

    public Owner(String name){
        this.name = name;
        ID = null;
        password = null;
    }

}

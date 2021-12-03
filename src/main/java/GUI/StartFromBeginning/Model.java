package GUI.StartFromBeginning;

public class Model {
    private String name;
    private String username;
    private String balance;

    public Model(){
        this.name = "";
        this.balance = "";
        this.username = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

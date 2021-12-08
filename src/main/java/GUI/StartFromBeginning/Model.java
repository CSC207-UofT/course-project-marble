package GUI.StartFromBeginning;

import entity.Bond;
import entity.Budget;
import entity.FinancialAsset;
import entity.Record;

import java.util.ArrayList;

public class Model {
    private String name;
    private String username;
    private String balance;
    private ArrayList<FinancialAsset> listOfAssets;
    private Budget budget;
    private ArrayList<Record> listOfRecords;
    private ArrayList<Record> listOfDepositRecords;
    private ArrayList<Record> listOfWithdrawalRecords;
    private ArrayList<Bond> listOfBonds;

    public ArrayList<Record> getListOfWithdrawalRecords() {
        return listOfWithdrawalRecords;
    }

    public void setListOfWithdrawalRecords(ArrayList<Record> listOfWithdrawalRecords) {
        this.listOfWithdrawalRecords = listOfWithdrawalRecords;
    }

    public ArrayList<Record> getListOfDepositRecords() {
        return listOfDepositRecords;
    }

    public void setListOfDepositRecords(ArrayList<Record> listOfDepositRecords) {
        this.listOfDepositRecords = listOfDepositRecords;
    }

    public Model(){
    }

    public ArrayList<Record> getListOfRecords() {
        return listOfRecords;
    }

    public void setListOfRecords(ArrayList<Record> listOfRecords) {
        this.listOfRecords = listOfRecords;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public ArrayList<FinancialAsset> getListOfAssets() {
        return listOfAssets;
    }

    public void setListOfAssets(ArrayList<FinancialAsset> listOfAssets) {
        this.listOfAssets = listOfAssets;
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

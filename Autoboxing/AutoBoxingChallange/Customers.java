package MasterClass.AutoBoxingChallange63;

import java.util.ArrayList;

/**
 * Created by LunguC on 11.07.2017.
 */
public class Customers {

    private String name;
    private ArrayList<Double> transactions;

    public Customers(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    // method for adding Transactions
    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }

}

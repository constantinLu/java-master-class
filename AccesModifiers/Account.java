package MasterClass.AccesModifiers;

import java.util.ArrayList;

/**
 * Created by LunguC on 22.08.2017.
 */
public class Account {

    public String accountName;
    public int balance = 0;
    public ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Balance is now " + this.balance);
        } else {
            System.out.println("Cannot deposit negative sums");
        }
    }

    public void withdrawl(int amount) {
        int withdrawl = -amount;
        if (withdrawl < 0) {
            transactions.add(withdrawl);
            this.balance += withdrawl;
            System.out.println(amount + " witdrawl from the account. Balance is now " + this.balance);
        } else {
            System.out.println("Not enough cash in the account");
        }
    }


    public void calculateBalance() {
        this.balance = 0;
        for (int i : this.transactions) {
            this.balance += i;
        }
        System.out.println("Calculated balance is : " + this.balance);
    }
}

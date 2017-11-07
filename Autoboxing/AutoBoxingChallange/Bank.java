package MasterClass.AutoBoxingChallange63;

import java.util.ArrayList;

/**
 * Created by LunguC on 11.07.2017.
 */
public class Bank {

    // fields
    private ArrayList<Branches> branches;
    private String name;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branches>();
    }

    public ArrayList<Branches> getBranches() {
        return branches;
    }

    public String getName() {
        return name;
    }

    // create a finding branche
    //helper method for other methods

    private Branches findBranches(String name) {
        for (int i = 0; i < branches.size(); i++) {
            Branches checkedBranches = this.branches.get(i);
            if (checkedBranches.getName().equals(name)) {
                return checkedBranches;
            }
        }
        return null;
    }

    // add a new branch
    public boolean addNewBranch(String name) {
        if (findBranches(name) == null) {
            this.branches.add(new Branches(name));
            return true;
        }
        return false;
    }

    // add customer to that branch with initial transaction
    public boolean addCustomerBranch(String branchName, String customerName, double initialAmount) {
        Branches branch = findBranches(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    // add a transcation for an existing customer for that branch

    public boolean addExistingCustomerTransaction(String branchName, String customerName, double amount) {
        Branches branch = findBranches(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    // show a list of customers for a particular branch and optionally a list
    public boolean showListOfCustomers(String branchName, boolean showTransactions) {
        Branches branch = findBranches(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());


            ArrayList<Customers> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customers branchCustomer = branchCustomers.get(i);
                System.out.println("Customers: " + branchCustomer.getName()
                        + "[" + (i + 1) + "]");

                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }

    }
}

package MasterClass.AutoBoxingChallange63;

import java.util.ArrayList;

/**
 * Created by LunguC on 11.07.2017.
 */
public class Branches {

    private String name;
    private ArrayList<Customers> customers;

    public Branches(String name) {
        this.name = name;
        this.customers = new ArrayList<Customers>();
    }

    public String getName() {

        return name;
    }

    public ArrayList<Customers> getCustomers() {
        return customers;
    }

    // finding customer method
    /// helpful for the other methods
    // is used internally in this class  and thats why is private
    private Customers findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            Customers checkedCustomer = this.customers.get(i);

            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }

    // method for adding a new customer to the branch
    // if the customers doesn`t exist.
    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customers(customerName, initialAmount));
            return true;
        }
        return false;
    }

    // method for transaction of an existing customer for that branch;
    public boolean addCustomerTransaction(String customerName, double amount) {
        Customers existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

}

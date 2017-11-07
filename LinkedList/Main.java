package MasterClass.LinkedList66;

import java.util.ArrayList;

/**
 * Created by LunguC on 12.07.2017.
 */
public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for custormer " + customer.getName() + " is  " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + " :" + intList.get(i));
        }
        System.out.println("\n");

        intList.add(1, 2);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + " :" + intList.get(i));
        }
    }
}

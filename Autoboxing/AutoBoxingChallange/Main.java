package MasterClass.AutoBoxingChallange63;

/**
 * Created by LunguC on 11.07.2017.
 */
public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("National Australia Bank");
        if (bank.addNewBranch("Adelaide")) {
            System.out.println("Branch created");
        }
        bank.addCustomerBranch("Adelaide", "Tim", 50.05);
        bank.addCustomerBranch("Adelaide", "Mike", 175.35);
        bank.addCustomerBranch("Adelaide", "Percy", 220.12);

        bank.addNewBranch("Sydney");
        bank.addCustomerBranch("Sydney", "Bob", 154.54);

        bank.addExistingCustomerTransaction("Adelaide", "Tim", 44.20);
        bank.addExistingCustomerTransaction("Adelaide", "Tim", 12.20);
        bank.addExistingCustomerTransaction("Adelaide", "Mike", 165.10);

        bank.showListOfCustomers("Adelaide", true);

        bank.showListOfCustomers("Sydney", true);


        bank.addNewBranch("Melbourne");

        if (!bank.addCustomerBranch("Melbourne", "Brian", 5.53)) {
            System.out.println("Error Melbourne branch does not exist");
        }

        if (!bank.addNewBranch("Adelaide")) {
            System.out.println("Adelaide branch already exists");
        }

        if (!bank.addExistingCustomerTransaction("Adelaide", "Fergus", 243032)) {
            System.out.println("Customer does not exist at the branch");
        }

        if (!bank.addCustomerBranch("Adelaide", "Tim", 12.12)) {
            System.out.println("Customer Tim already exists");

        }

    }


}

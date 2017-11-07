package MasterClass.oopBank;

public class MyAccount {

    //intializing the fields

    private int bankAccount;
    private double balance;
    private String customerName;
    private String email;
    private long phoneNo;

    public MyAccount() {
        this(231, 24, "Default name", "Def", 123);
        System.out.println("Empty constructor");

    }


    public MyAccount(int bankAccount, double balance, String customerName, String email, long phoneNo) {
        super();
        this.bankAccount = bankAccount;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public static void main(String[] args) {

        MyAccount st = new MyAccount(312, 0.00, "Tom Lee", "dasd@fasd.com",
                0746645);
        st.setBalance(100);
        st.setBankAccount(13142132);
        st.setCustomerName("Stan Tanescu");
        st.setEmail("stanescu@hmot.msg");
        st.setPhoneNo(07471);
        st.deposit(1800.0);
        st.withdraw(1900);
        System.out.println(" Have a great day ! ");


    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposit of " + amount + " processed.    Balance : " + balance);
    }

    public void withdraw(double amount) {
        if (balance - amount <= 0) {
            System.out.println("Insufficient funds. I NEED MONEY ! $$$");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawal of " + amount + " processed.   Remaining balance : " + balance);
        }
    }

}

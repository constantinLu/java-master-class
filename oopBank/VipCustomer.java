package MasterClass.oopBank;

public class VipCustomer {

    // fields
    private String name;
    private double creditLimit;
    private String email;

    //constructors
    public VipCustomer() {
        this("Default name", 1000, "Default email");
    }


    public VipCustomer(String name, double creditLimit) {
        this(name, creditLimit, "Default Constructor");

    }

    public VipCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public static void main(String[] args) {

        VipCustomer gates = new VipCustomer();
        System.out.println(gates.getName());


    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

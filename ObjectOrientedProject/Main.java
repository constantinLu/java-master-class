package MasterClass.ObjectOrientedProject;

public class Main {

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "white");
        //double price = hamburger.itemizeHamburger();
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.13);
        System.out.println("Total Burger price is " + hamburger.itemizeHamburger());


        HealthyBurger HealthyB = new HealthyBurger("Bacon", 5.67);
        //HealthyB.itemizeHamburger();
        HealthyB.addHamburgerAddition1("Egg", 5.43);
        //HealthyB.itemizeHamburger();
        HealthyB.addHealthAddition1("Lentils", 3.41);
        System.out.println("Total Burger price is " + HealthyB.itemizeHamburger());

        DeluxeBurger db = new DeluxeBurger();
        db.addHamburgerAddition2("Extra Patty", 3.67);
        System.out.println("Total Burger price is " + db.itemizeHamburger());


    }

}

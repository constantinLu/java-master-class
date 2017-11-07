package MasterClass.oopInheritance;

public class Main {

    public static void main(String[] args) {
        Animal A = new Animal("Animal", 1, 1, 5, 5);
        Dog D = new Dog("Amstaff", 8, 2, 4, 1, 20, 23, "Furry");
        D.eat();
        D.walk();
        //D.run();
    }

}
 
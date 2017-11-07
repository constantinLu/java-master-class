package MasterClass.Abstraction;

/**
 * Created by LunguC on 21.08.2017.
 */
public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breath();
        dog.eat();

        Parrot par = new Parrot("Australian ringneck");
        par.breath();
        par.eat();
        par.fly();

        Penguin pen = new Penguin("Emperor");
        pen.fly();
    }
}

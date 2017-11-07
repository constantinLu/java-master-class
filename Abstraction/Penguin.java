package MasterClass.Abstraction;

/**
 * Created by LunguC on 21.08.2017.
 */
public class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("I`m not very good at that, can I go swim instead?!");
    }
}

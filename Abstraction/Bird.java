package MasterClass.Abstraction;

/**
 * Created by LunguC on 21.08.2017.
 */
public abstract class Bird extends Animal implements CanFly {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
    }


    @Override
    public void breath() {
        System.out.println("Breath in, breath out, repeat");
    }


    //adding an abstract method


    @Override
    public void fly() {
        System.out.println(getName() + " It`s flapping it`s wings");
    }
}

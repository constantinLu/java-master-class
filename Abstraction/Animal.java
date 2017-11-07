package MasterClass.Abstraction;

/**
 * Created by LunguC on 21.08.2017.
 */
//
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    //adding abstarct method
    public abstract void eat();

    public abstract void breath();

    //getter
    public String getName() {
        return name;
    }
}

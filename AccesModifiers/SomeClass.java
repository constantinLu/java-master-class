package MasterClass.AccesModifiers;

/**
 * Created by LunguC on 22.08.2017.
 */
public class SomeClass {

    private static int classCounter = 0;
    public final int instanceNumber;
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance is : " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}

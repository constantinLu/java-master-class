package MasterClass.Static;

/**
 * Created by LunguC on 22.08.2017.
 */
public class StaticTest {

    private static int numInstances = 0;
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }


}

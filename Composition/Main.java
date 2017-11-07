package MasterClass.composition;

public class Main {

    public static void main(String[] args) {


        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("220B", "Dell", "240", dimensions);
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));
        Motherboard theMoatherboard = new Motherboard("bj-235", "Asrock", 4, 6, "v.2.44");

        ;
    }

}

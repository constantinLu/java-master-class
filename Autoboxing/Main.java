package MasterClass.Autoboxing62;

import java.util.ArrayList;
// the concept of autoboxing
// wrappers

/**
 * Created by LunguC on 11.07.2017.
 */


//creating a wrapper
class IntClass {
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}


public class Main {


    public static void main(String[] args) {
        String[] array = new String[10];
        int[] intArray = new int[10];
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Tim");

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<IntClass> intClassArray = new ArrayList<IntClass>();
        intClassArray.add(new IntClass(20));
        Integer Integer = new Integer(30);
        Double doubleValue = new Double(30.25);

        ArrayList<Integer> intAr = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            intAr.add(java.lang.Integer.valueOf(i));
        }
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " --------> " + intAr.get(i).intValue());
        }


        // autoboxing and unboxing (concept)
        Integer myIntValue = 56;     // Integer.valueOf(56); (compileTime);
        int myInt = myIntValue;      // myInt.intValue();    (compileTime);


        //  autoboxing and unboxing of the doubles objects
        ArrayList<Double> myD = new ArrayList<>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            myD.add(Double.valueOf(dbl));
        }
        for (int i = 0; i < myD.size(); i++) {
            double value = myD.get(i).doubleValue();
            System.out.println(i + " --------- >>> " + value);
        }

    }

}

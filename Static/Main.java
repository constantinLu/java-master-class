package MasterClass.Static;

import MasterClass.AccesModifiers.SomeClass;

/**
 * Created by LunguC on 22.08.2017.
 */
public class Main {

//    public static int multiplier = 7;

    public static void main(String[] args) {

//
//        StaticTest firstIn = new StaticTest("firstIn");
//        System.out.println(firstIn.getName() + " is instance number " + StaticTest.getNumInstances());
//
//        StaticTest secondIn = new StaticTest("secondIn");
//        System.out.println(secondIn.getName() + " is instance number " + StaticTest.getNumInstances());
//
//        StaticTest thirdIn = new StaticTest("thirdIn");
//        System.out.println(thirdIn.getName() + " is instance number " + StaticTest.getNumInstances());

//    int ans = multiply(6);
//        System.out.println("Answer  " + ans);
//
//
//}
//
//    public static int multiply(int number) {
//        return number * multiplier;


        // final KEYWORD

        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        //one.instanceNumber = 4;

        System.out.println(Math.PI);

    }

}

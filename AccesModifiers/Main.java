package MasterClass.AccesModifiers;

/**
 * Created by LunguC on 22.08.2017.
 */
public class Main {
    public static void main(String[] args) {

//        Account acc = new Account("LTBT2335");
//        System.out.println("ACOUNT : " + acc.accountName);
//        acc.deposit(1000);
//        acc.withdrawl(500);
//        acc.withdrawl(-200);
//        acc.deposit(-20);
//        acc.calculateBalance();
//        acc.balance = 5000;
//
//
//        System.out.println("Balance on acount is : " + acc.getBalance());
//        acc.transactions.add(4500);
//        acc.calculateBalance();

//        SomeClass one =  new SomeClass("one");
//        SomeClass two = new SomeClass("two");
//        SomeClass three = new SomeClass("three");
//
//        System.out.println(one.getInstanceNumber());
//        System.out.println(two.getInstanceNumber());
//        System.out.println(three.getInstanceNumber());
//
//        //one.instanceNumber = 4;
//
//        System.out.println(Math.PI);
//        int pw = 123456;
//        Password pas = new ExtendedPassword(pw);
//        pas.storePassword();
//
//        pas.letMeIn(1);
//        pas.letMeIn(3215);
//        pas.letMeIn(525346346);
//        pas.letMeIn(123456);


        // SIBTest

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);
    }
}

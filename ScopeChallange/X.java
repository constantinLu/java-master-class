package MasterClass.ScopeChallange;

import java.util.Scanner;

/**
 * Created by LunguC on 22.08.2017.
 */
public class X {

    private int x;

    public X(Scanner x) {
        System.out.println("Please enter a number: ");
        this.x = x.nextInt();

    }

    public void x() {
        for (int x = 1; x <= 12; x++) {
            System.out.println(x + " times " + this.x + " equals " + x * this.x);
        }
    }
}

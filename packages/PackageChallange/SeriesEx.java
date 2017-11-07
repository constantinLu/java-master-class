package MasterClass.packages.PackageChallange;

/**
 * Created by LunguC on 22.08.2017.
 */
public class SeriesEx {

    //nsum
    public static long nSum(int n) {
        return (n * (n + 1)) / 2;
    }

    //factorial

    public static long factorial(int n) {
        if (n == 0) {
            return 0;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // fibonaci
    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        long nMinus1 = 1;
        long nMinus2 = 0;
        long fib = 0;
        for (int i = 1; i < n; i++) {
            fib = (nMinus2 + nMinus1);
            nMinus2 = nMinus1;
            nMinus1 = fib;
        }
        return fib;
    }


}

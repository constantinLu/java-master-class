package MasterClass.ExceptionHandling;

public class ThrowExplicitlyOtherMethod {

    public static void main(String[] args)
    {
        try
        {
            methodWithThrow();
        }
        catch(NumberFormatException ex)
        {
            System.out.println("NumberFormatException object thrown in methodWithThrow() method will be handled here");
        }
    }

    static void methodWithThrow()
    {
        try
        {
            NumberFormatException ex = new NumberFormatException("This is an object of NumberFormatException");

            throw ex;        //throwing NumberFormatException object explicitly using throw keyword
        }
        catch(ArithmeticException ex)
        {
            System.out.println("Explicitly thrown NumberFormatException object will not be caught here");
        }
    }
}

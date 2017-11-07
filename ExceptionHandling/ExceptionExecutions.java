package MasterClass.ExceptionHandling;

public class ExceptionExecutions {

    public static void main(String[] args)
    {
        System.out.println("You can keep any number of statements here");

        try
        {
            int i = 10/0;           //This statement throws ArithmeticException

            System.out.println("This statement will not be executed");
        }

        //You can't keep statements here

        catch(ArithmeticException ex)
        {
            System.out.println("This block is executed immediately after an exception is thrown");
        }

        //You can't keep statements here

        finally
        {
            System.out.println("This block is always executed");
        }

        System.out.println("You can keep any number of statements here");
    }
}


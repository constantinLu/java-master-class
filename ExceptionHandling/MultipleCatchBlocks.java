package MasterClass.ExceptionHandling;

public class MultipleCatchBlocks {

    public static void main(String[] args)
    {
        String[] s = {"abc", "123", null, "xyz"};   //String array containing one null object

        for (int i = 0; i < 5; i++)
        {
            try
            {
                int a = s[i].length() + Integer.parseInt(s[i]);

                //This statement may throw NumberFormatException, NullPointerException and ArrayIndexOutOfBoundsException

            }

            catch(NumberFormatException ex)
            {
                System.out.println("NumberFormatException will be caught here");
            }

            catch (ArrayIndexOutOfBoundsException ex)
            {
                System.out.println("ArrayIndexOutOfBoundsException will be caught here");
            }

            catch (NullPointerException ex)
            {
                System.out.println("NullPointerException will be caught here");
            }

            System.out.println("After executing respective catch block, this statement will be executed");
        }



        // other version with the pipe

        for (int i = 0; i < 6; i++)
        {
            try
            {
                int a = s[i].length() + Integer.parseInt(s[i]);

                //This statement may throw NumberFormatException, NullPointerException and ArrayIndexOutOfBoundsException
            }

            catch(NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex)
            {
                System.out.println("Now, this block handles NumberFormatException, NullPointerException and ArrayIndexOutOfBoundsException");
            }
        }
    }
}

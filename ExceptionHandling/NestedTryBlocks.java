package MasterClass.ExceptionHandling;

public class NestedTryBlocks {

    public static void main(String[] args)
    {
        String[] s = {"abc", "123", null, "xyz"};   //String array containing one null object

        for (int i = 0; i < s.length; i++)
        {
            try     //Outer try block
            {
                int a = s[i].length();    //This statement may throw NullPointerException

                try    //Inner try block
                {
                    a = Integer.parseInt(s[i]);    //This statement may throw NumberFormatException
                }
                catch (NumberFormatException ex)   //Inner catch block
                {
                    System.out.println("NumberFormatException will be caught here");
                }
            }
            catch(NullPointerException ex)     //Outer catch block
            {
                System.out.println("NullPointerException will be caught here");
            }
        }


        System.out.println("-----------------");
        String[] s2 = {"abc", "123", null, "xyz"};   //String array containing one null object

        for (int j = 0; j < s2.length; j++)
        {
            //First Level try-catch block
            try
            {
                int a = s[j].length();    //This statement may throw NullPointerException

                //second level try-catch block
                try
                {
                    System.out.println(s[j+1]);   //This statement may throw ArrayIndexOutOfBoundsException

                    //third level try-catch block
                    try
                    {
                        a = Integer.parseInt(s[j]);    //This statement may throw NumberFormatException
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("NumberFormatException will be caught here");
                    }
                }
                catch (ArrayIndexOutOfBoundsException ex)
                {
                    System.out.println("ArrayIndexOutOfBoundsException will be caught here");
                }
            }
            catch(NullPointerException ex)
            {
                System.out.println("NullPointerException will be caught here");
            }
        }
    }
}


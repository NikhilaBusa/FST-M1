package activities;

class CustomException extends Exception
{
    private String message;
    public CustomException(String m)
    {
        message = m;
    }
    @Override
    public String getMessage()
    {
        return message;
    }
}
public class Activity8 {
    static void exceptionTest(String par) throws CustomException
    {
        if(par != null)
            System.out.println(par);
        else
            throw new CustomException("String is null");
    }
    public static void main(String[] args)
    {
        try
        {
            Activity8.exceptionTest("Not a null string");
            Activity8.exceptionTest(null);
        }
        catch(CustomException e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

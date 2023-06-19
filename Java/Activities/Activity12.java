package activities;

interface Addable
{
    public int add(int a, int b);
}
public class Activity12 {
    public static void main(String[] args)
    {
        Addable ad1 = (a, b)-> (a+b);
        Addable ad2 = (int a, int b) -> {
            return(a+b);
        };
        System.out.println("Without return expression: " + ad1.add(10,20));
        System.out.println("With return expression: " + ad2.add(10,20));


    }
}

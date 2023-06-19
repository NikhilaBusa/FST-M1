package activities;

public class Activity2 {
    public static void main(String[] args)
    {
        int[] numList = {10,77,10,54,-11,10};
        int sum=0;
        int totalSum = 30;
        for(int number:numList)
        {
            if(number==10)
                sum+=number;
        }
        System.out.println("Result:" + (sum==totalSum));
    }
}

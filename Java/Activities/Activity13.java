package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Random indexGen = new Random();
        System.out.println("Enter integers and press EOF");
        while(obj.hasNextInt())
        {
            list.add(obj.nextInt());
        }
        Integer nums[] = list.toArray(new Integer[0]);
        int index= indexGen.nextInt(nums.length);
        System.out.println("Index value: " + index + " Number is: " + nums[index]);
        obj.close();
    }
}

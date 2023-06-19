package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args)
    {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("S1");
        myList.add("S2");
        myList.add("S3");
        myList.add("S4");
        myList.add("S5");
        myList.add(3,"S6");
        System.out.println("Items in array list:");
        for(String s : myList)
            System.out.println(s);
        System.out.println("3rd item: " + myList.get(2));
        System.out.println("My list contains Mango: " + myList.contains("Mango"));
        System.out.println("Size of my list before removing: " + myList.size());
        myList.remove("S3");
        System.out.println("Size after removing: " + myList.size());
    }
}

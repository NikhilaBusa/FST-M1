package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args)
    {
        HashSet<String> hs = new HashSet<String>();
        hs.add("Rohit");
        hs.add("Surya");
        hs.add("Ishan");
        hs.add("Rishab");
        hs.add("Jadeja");
        hs.add("Rahane");
        System.out.println("Size: " + hs.size());
        System.out.println("Dropped Ishan? " + hs.remove("Ishan"));
        System.out.println("Dropped Kohli? " + hs.remove("Kohli"));
        System.out.println("Dhoni in team: " + hs.contains("Dhoni"));
        System.out.println("Team: " + hs);
        System.out.println("Size after removing: " + hs.size());
    }
}

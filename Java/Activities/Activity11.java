package activities;

import java.util.*;

public class Activity11 {
    public static void main(String[] args)
    {
        HashMap<Integer, String> colors = new HashMap<>();
        colors.put(1,"Violet");
        colors.put(2,"Indigo");
        colors.put(3,"Blue");
        colors.put(4,"Green");
        colors.put(5,"Yellow");
        System.out.println("Map before removal: " + colors.entrySet() + ", Size before removal: " + colors.size());
        colors.remove(3);
        System.out.println("Map after removal: " + colors + ", Size after removal: " + colors.size());
        System.out.println("Has green? " + colors.containsValue("Green"));
        System.out.println("Final size: " + colors.size());

    }
}

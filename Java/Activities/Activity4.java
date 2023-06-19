package activities;

public class Activity4 {
    public static void ArraySort(int[] array)
    {
        int size=array.length,j;
        for(int i=1; i<size; i++)
        {
            int key = array[i];
            j=i-1;
            while(j>=0 && key<array[j])
            {
                array[j+1] = array[j];
                array[j] = key;
                j--;
            }
        }
        System.out.println("After sort:");
        for(int num:array)
            System.out.print(" " + num);
    }
    public static void main(String[] args)
    {
        int[] unsortedArr = {9, 5, 1, 4, 3};
        System.out.print("Before Sort: ");
        for(int num:unsortedArr)
            System.out.print(" " + num);
        System.out.println(" ");
        ArraySort(unsortedArr);
    }
}

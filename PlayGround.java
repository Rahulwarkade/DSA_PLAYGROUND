import java.util.*;

public class PlayGround
{  
    public static void main(String args[])
    {
        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int value : arr1) set.add(value);
        for(int value : arr2) set.add(value);

        System.out.println("Union is = "+ set.size());

        set = new HashSet<>();
        for(int value : arr1) set.add(value);

        int count = 0;
        for(int value : arr2)
        {
            if(set.contains(value))
            {
                count++;
                set.remove(value);
            }
        }

        System.out.println("Intersection = "+count);
        
    }
}
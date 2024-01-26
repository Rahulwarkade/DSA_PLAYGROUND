import java.util.*;

public class PlayGround
{  
    public static void main(String args[])
    {
        int[] num = {4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> set = new HashSet<>();

        for(int value : num)
            set.add(value);
        
        System.out.println("Distinct Elements = "+ set.size());
    }
}
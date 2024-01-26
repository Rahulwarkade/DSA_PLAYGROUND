import java.util.*;

public class PlayGround
{  
    public static void main(String args[])
    {
        int[] arr = {15,-2,2,-8,1,7,10};
        int sum = 0;
        int len = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++)
        {
            sum += arr[i];

            if(map.containsKey(sum))
            {
                len = Math.max(len,i-map.get(sum));
            }
            else
            {
                map.put(sum, i);
            }
        }

        System.out.println("Largest Subarray with 0 sum = "+ len);
    }
}
import java.util.*;

public class PlayGround
{  
    public static void main(String args[])
    {
        int[] nums = {1,3,2,5,1,3,1,5,1};
        int n = 9;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            int num = nums[i];
            if(map.containsKey(num))
            {
                map.put(num,map.get(num)+1);
            }
            else
            {
                map.put(num,1);
            }
        }

        Set<Integer> keys = map.keySet();

        for(Integer key : keys)
        {
            if(map.get(key)>n/3)
            {
                System.out.println(key);
            }
        }
    }
}
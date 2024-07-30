import java.util.*;

public class Java_PlayGround {


    public static int unboundedKnapsack(int[] val,int[] wt,int W,int item)
    {

        if(W<=0 || item==wt.length) return 0;

        if(wt[item]<=W)
        {
            return Math.max(val[item]+unboundedKnapsack(val,wt,W-wt[item],item),unboundedKnapsack(val,wt,W,item+1));
        }
        else{
            return unboundedKnapsack(val,wt,W,item+1);
        }
    }

    public static void main(String[] args) {
    
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};

        System.out.println(unboundedKnapsack(val,wt,7,0));
    }
}

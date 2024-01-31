import java.util.*;

public class PlayGround
{  
    
    public static int climbingStairs(int n,int[] dp)
    {
        if(n==0) return 1;
        if(n<0) return 0;

        if(dp[n]!=0) return dp[n];
        return dp[n] = climbingStairs(n-1, dp)+climbingStairs(n-2, dp);
    }
    public static void main(String args[])
    {
        int n = 5;
        int[] dp = new int[n+1];
        System.out.println(climbingStairs(n,dp));
    }
}
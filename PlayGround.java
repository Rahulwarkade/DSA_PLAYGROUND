import java.util.*;

public class PlayGround
{  
    
    public static int climbingStairs(int n,int[] dp)
    {
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[])
    {
        int n = 5;
        int[] dp = new int[n+1];
        System.out.println(climbingStairs(n,dp));
    }
}
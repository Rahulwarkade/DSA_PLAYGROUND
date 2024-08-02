import java.util.*;

public class Java_PlayGround{

    public static int catalanNumber(int n,int[] dp)
    {
        if(dp[n]!=-1) return dp[n];
        if(n==1 || n==0) return 1;

        int catalan = 0;

        for(int i=0; i<n; i++)
        {
            catalan += catalanNumber(i,dp) * catalanNumber(n-i-1,dp);
        }

         return dp[n] = catalan;
    }
    public static void main(String[] args) {
        int n =4;

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(catalanNumber(n,dp));

    }
}

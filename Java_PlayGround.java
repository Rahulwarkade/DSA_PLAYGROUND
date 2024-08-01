import java.util.*;

public class Java_PlayGround{


    public static int lcsTab(String str1,String str2)
    {
        int N = str1.length();
        int M = str2.length();
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[N+1][M+1];
        for(int i=0; i<=N; i++)
        {
            for(int j=0; j<=M; j++)
            {
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else 
                {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    
        String str1 = "abcde";
        String str2 = "acde";


        System.out.println(lcsTab(str1,str2));
    }
}

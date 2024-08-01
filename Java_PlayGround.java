import java.util.*;

public class Java_PlayGround{

    public static boolean wildCardMatching(String pattern1, String pattern2)
    {
        int N = pattern1.length();
        int M = pattern1.length();
        boolean[][] dp = new boolean[N+1][M+1];
        dp[0][0] = true;
        for(int i=1; i<=N; i++) dp[0][i] = false;

        for(int i=1; i<=M; i++)
        {
            if(pattern2.charAt(i)=='*')
                dp[i][0] = dp[i-1][0];
            else 
                dp[i][0] = false;
        }

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                if(pattern1.charAt(i-1)==pattern2.charAt(j-1) || pattern1.charAt(i-1)=='?')
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else 
                {
                    dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
                }
            }
        }
        return dp[N][M];
    }

    public static void main(String[] args) {
    
        String str1 = "baaabaad";
        String str2 = "*****ba*ad";


        System.out.println(wildCardMatching(str1,str2));
    }
}

import java.util.*;

public class Java_PlayGround{

    public static int editDistance(String word1, String word2)
    {
        int N = word1.length();
        int M = word2.length();

        int[][] dp = new int[N+1][M+1];

        for(int i=0; i<=N; i++) dp[0][i] = i;
        for(int i=1; i<=M; i++) dp[i][0] = i;

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else 
                {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }
            }
        }
        return dp[N][M];
    }

    public static void main(String[] args) {
    
        String str1 = "insertion";
        String str2 = "execution";


        System.out.println(editDistance(str1,str2));
    }
}

import java.util.*;

public class Java_PlayGround{

    public static int mcm(int[] matrix,int i,int j,int[][] dp)
    {
        if(i==j) return 0;
        int minCost = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i; k<j; k++)
        {
            int leftCost = mcm(matrix,i,k,dp);
            int rightCost = mcm(matrix,k+1,j,dp);
            int result = (matrix[i-1]*matrix[k]*matrix[j]);

            result += (leftCost+rightCost); 
            minCost = Math.min(minCost,result);
        }

        return dp[i][j] = minCost;
    }
    public static void main(String[] args) {

        int matrix[] = {1,2,3,4,3};
        int n = 5;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i],-1);

        System.out.println(mcm(matrix,1,n-1,dp));

    }
}

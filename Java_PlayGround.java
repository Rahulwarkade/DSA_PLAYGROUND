import java.util.*;

public class Java_PlayGround{

    public static int mcm(int[] matrix,int i,int j)
    {
        if(i==j) return 0;
        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<j; k++)
        {
            int leftCost = mcm(matrix,i,k);
            int rightCost = mcm(matrix,k+1,j);
            int result = (matrix[i-1]*matrix[k]*matrix[j]);

            result += (leftCost+rightCost); 
            minCost = Math.min(minCost,result);
        }

        return minCost;
    }
    public static void main(String[] args) {

        int matrix[] = {1,2,3,4,3};

        System.out.println(mcm(matrix,1,4));

    }
}

import java.util.*;

public class PlayGround
{
    public static void printArr(int[][] arr)
    {
        int n = arr.length,m = arr[0].length;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        int[] A = {4,1,8,7};
        int[] B = {2,3,6,5};

        Arrays.sort(A);
        Arrays.sort(B);
        int diff = 0;
        for(int i=0; i<A.length; i++)
        {
            int temp = A[i]-B[i];
            diff += Math.abs(temp);
        }

        System.out.println(diff);
    }
}
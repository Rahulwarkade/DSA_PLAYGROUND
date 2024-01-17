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
        int[] value = {60,100,120};
        int[] weight = {10,20,30};
        int W = 50;
        int n = value.length;
        double[][] ratio = new double[n][2];

        for(int i=0; i<n; i++)
        {
            ratio[i][0] = i;
            ratio[i][1] = (value[i]/weight[i]);
        }

        Arrays.sort(ratio,Comparator.comparingDouble(row -> row[1]));

        int ans = 0;
        for(int i=n-1; i>=0; i--)
        {
            int idx = (int)ratio[i][0];
            if(weight[idx]<=W)
            {
                ans += value[idx];
                W-=weight[idx];
            }
            else
            {
                ans += (ratio[i][1]*W);
                W = 0;
                break;
            }
        }

        System.out.println(ans);
    }
}
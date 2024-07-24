import java.util.*;

class Java_PlayGround
{
 
    public static int _01Knapsack(int[] val,int[] wt,int W,int item)
    {
        if(item==val.length || W<=0) return 0;

        if(W>=wt[item])
            return Math.max(val[item] + _01Knapsack(val,wt,W-wt[item],item+1),_01Knapsack(val,wt,W,item+1));
        else
            return _01Knapsack(val,wt,W,item+1);
    }

    public static void main(String args[])
    {
        int N;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int[] val = new int[N];
        int[] wt = new int[N];

        for(int i=0; i<N; i++)
        {
            val[i] = sc.nextInt();
        }

        for(int i=0; i<N; i++)
        {
            wt[i] = sc.nextInt();
        }

        System.out.println(_01Knapsack(val,wt,7,0));
    }
}


import java.util.*;

class Java_PlayGround
{
 
    public static void printTable(int [][] tab)
    {
        for(int i=0; i<tab.length; i++)
        {
            for (int j=0; j<tab[0].length; j++) {
                System.out.print(tab[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int tabulation(int[] val,int[] wt,int W)
    {
        int N = val.length;
        int table[][] = new int[N+1][W+1];

        for(int i=0; i<=N; i++)
        {
            table[i][0] = 0;
        }
        for(int i=0; i<=W; i++)
        {
            table[0][i] = 0;
        }

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=W; j++)
            {
                int cost = val[i-1];
                int weight = wt[i-1];
                if(weight<=j)
                {
                    int ans1 = cost + table[i-1][j-weight];
                    int ans2 = table[i-1][j];
                    table[i][j] = Math.max(ans1,ans2);
                }
                else
                {
                    table[i][j] = table[i-1][j];
                }
            }
        }
        printTable(table);


        return table[N][W];
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

        System.out.println(tabulation(val,wt,15));
    }
}


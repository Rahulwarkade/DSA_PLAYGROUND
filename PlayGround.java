import java.util.*;

public class PlayGround
{  
    public static int N = 7;
    public static int[] parent = new int[N];
    public static int[] rank = new int[N];

    public static void make()
    {
        for(int i=0; i<N; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x)
    {
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a,int b)
    {
        a = find(a);
        b = find(b);
        if(a!=b)
        {
            if(rank[a]==rank[b])
            {
                parent[b] = a;
                rank[a]++;
            }
            else if(rank[a]>rank[b])
            {
                parent[b] = a;
            }
            else if(rank[a]<rank[b])
            {
                parent[a] = b;
            }
        }
    }

    public static void main(String args[])
    {
        make();
        System.out.println(find(3));
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);
    }
}
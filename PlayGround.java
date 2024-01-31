import java.util.*;

public class PlayGround
{  
    public static class Edge implements Comparable<Edge>
    {
        int src;
        int dst;
        int wt;
        Edge(int src,int dst,int wt)
        {
            this.src = src;
            this.dst = dst;
            this.wt  = wt;
        }

        @Override
        public int compareTo(Edge obj)
        {
            return this.wt - obj.wt;
        }
    }
    public static int N = 4;
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

    public static void krushkalsAlgo(int[][] edges,int V)
    {
        int minCost = 0;
        make();
        ArrayList<Edge> list = new ArrayList<>();

        for(int i=0; i<edges.length; i++)
        {
            int src = edges[i][0];
            int dst = edges[i][1];
            int wt = edges[i][2];
            list.add(new Edge(src,dst,wt));
        }
        Collections.sort(list);

        for(int i=0; i<V-1; i++)
        {
            Edge e = list.get(i);
            int a = e.src;
            int b = e.dst;
            a = find(a);
            b = find(b);
            if(a!=b)
            {
                union(a,b);
                minCost+=e.wt;
            }
        }

        System.out.println("Minimum Cost using Krushkals algo = "+minCost);
    }
    public static void main(String args[])
    {
        int V = 4;
        int edges[][] = {{0,1,10},{0,2,15},{0,3,30},{1,3,40},{2,3,50}};
        
        krushkalsAlgo(edges,V);
    }
}
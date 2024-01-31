import java.util.*;

public class PlayGround
{  
    public static class Edge
    {
        int sr;
        int dt;
        int wt;
        Edge(int sr,int dt,int wt)
        {
            this.sr = sr;
            this.dt = dt;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair>
    {
        int v;
        int wt;

        Pair(int v,int wt)
        {
            this.v = v;
            this.wt = wt;
        }
        @Override
        public int compareTo(Pair ob2)
        {
            return this.wt - ob2.wt;
        }
    }

    public static void primsAlgo(ArrayList<Edge>[] graph,int source)
    {
        boolean vis[] = new boolean[graph.length];
        Arrays.fill(vis,false);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source,0));
        int minCost = 0;
        while(!pq.isEmpty())
        {
            Pair node = pq.remove();
            if(!vis[node.v])
            {
                minCost += node.wt;
                vis[node.v] = true;
                for(Edge child : graph[node.v])
                {
                    if(vis[child.dt]) continue;                    
                    pq.add(new Pair(child.dt,child.wt));
                }
            }
        }

        System.out.println("Minimum cost = "+minCost);
    }
    public static void main(String args[])
    {
        int N  = 6;
        int[][] edges = {{0,1,10},{0,2,15},{0,3,30},{1,3,40},{2,3,50}};
        int M = edges.length;

        ArrayList<Edge>[] Edges = new ArrayList[N];

        for(int i=0; i<N; i++)
        {
            Edges[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++)
        {
            int x = edges[i][0];
            int y = edges[i][1];
            int wt = edges[i][2];
            Edges[x].add(new Edge(x,y,wt));
            Edges[y].add(new Edge(y,x,wt));
        }

        primsAlgo(Edges,0);
    }
}
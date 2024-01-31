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
    public static void bellmanFord(ArrayList<Edge>[] graph,int source)
    {
        int N = graph.length;
        int[] distance = new int[N];

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source] = 0;

        for(int i=0; i<N-1; i++)
        {
            for(int v=0; v<N; v++)
            {
                for(Edge child : graph[v])
                {
                    if(distance[v]!=Integer.MAX_VALUE && distance[v] + child.wt < distance[child.dt])
                    {
                        distance[child.dt] = distance[v] + child.wt;
                    }
                }
            }
        }

        for(int i=0; i<distance.length; i++)
        {
            System.out.println(i+" distance = "+distance[i]);
        }
    }
    public static void main(String args[])
    {
        int N  = 6;
        int[][] edges = {{0,1,2},{0,2,4},{1,2,-4},{2,3,2},{3,4,4},{4,1,-1}};
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
            // Edges[y].add(new Edge(y,x,1));
        }

        bellmanFord(Edges,0);
    }
}
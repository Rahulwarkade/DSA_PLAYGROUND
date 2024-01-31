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

    public static class Info implements Comparable<Info>
    {
        int v;
        int wt;
        int k;
        Info(int v,int wt,int k)
        {
            this.v = v;
            this.wt = wt;
            this.k = k;
        }
        @Override
        public int compareTo(Info ob2)
        {
            return this.k - ob2.k;
        }
    }

    public static void cheapestFlights(ArrayList<Edge>[] graph,int source,int destination,int stops)
    {
        int[] distance = new int[graph.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(source,0,0));
        distance[source] = 0;

        while(!pq.isEmpty())
        {
            Info node = pq.remove();
            if(node.k<=stops)
            {
                for(Edge child : graph[node.v])
                {
                    if(distance[node.v]!= Integer.MAX_VALUE && distance[node.v]+child.wt<distance[child.dt])
                    {
                        distance[child.dt] = distance[node.v] + child.wt;
                        pq.add(new Info(child.dt,distance[child.dt],node.k+1));
                    }
                }
            }
        }
        if(distance[destination]==Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }
        else{
            System.out.println(distance[destination]);
        }
    }

    public static void main(String args[])
    {
        int N  = 3;
        int[][] edges = {{0,1,100},{0,2,500},{1,2,100}};
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
            // Edges[y].add(new Edge(y,x,wt));
        }

        cheapestFlights(Edges,0,2,1);
    }
}
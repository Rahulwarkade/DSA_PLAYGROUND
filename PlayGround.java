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
    public static void dijkstrasAlgo(ArrayList<Edge>[] graph,int source)
    {
        int N = graph.length;
        int[] distance = new int[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(visited,false);
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        pq.add(new Pair(source,0));
        distance[source] = 0;

        while(!pq.isEmpty())
        {
            Pair node = pq.remove();
            if(visited[node.v]) continue;
            visited[node.v] = true;
            for(Edge child : graph[node.v])
            {
                if(distance[node.v]+child.wt<distance[child.dt])
                {
                    distance[child.dt] = distance[node.v]+child.wt;
                    pq.add(new Pair(child.dt,distance[child.dt]));
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
        int[][] edges = {{0,1,2},{0,2,4},{1,2,1},{1,3,7},{2,4,3},{3,5,1},{4,3,2},{4,5,5}};
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

        dijkstrasAlgo(Edges,0);
    }
}
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

    public static void calcIndeg(ArrayList<Edge>[] graph,int[] indeg)
    {
        int N = graph.length;
        for(int i=0; i<N; i++)
        {
            for(Edge child : graph[i])
            {
                indeg[child.dt]++;
            }
        }
    }
    public static void topSortKahnsAlgo(ArrayList<Edge>[] graph)
    {
        int N = graph.length;
        int[] indeg = new int[N];
        calcIndeg(graph,indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<N; i++)
        {
            if(indeg[i]==0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int node = q.remove();
            System.out.print(node+" ");
            for(Edge child : graph[node])
            {
                indeg[child.dt]--;
                if(indeg[child.dt]==0)
                {
                    q.add(child.dt);
                }
            }
        }
    }
    public static void main(String args[])
    {
        int N  = 6;
        int[][] edges = {{2,3},{3,1},{4,1},{4,0},{5,0},{5,2}};
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
            Edges[x].add(new Edge(x,y,1));
            // Edges[y].add(new Edge(y,x,1));
        }

        topSortKahnsAlgo(Edges);
    }
}
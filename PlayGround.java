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

    public static void levelOrder(ArrayList<Edge>[] graph,int root)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited,false);
    
        q.add(root);
        visited[root] = true;
        while(!q.isEmpty())
        {
            int node = q.remove();
            System.out.print(node+" ");
            for(Edge edges : graph[node])
            {
                if(!visited[edges.dt])
                {
                    q.add(edges.dt);
                    visited[edges.dt] = true;
                }
            }
        }
    }
    public static void main(String args[])
    {
        int N  = 7;
        // int[][] edges = {{0,1},{1,2},{1,3},{2,3},{2,4}};
        int[][] edges = {{0,1},{0,2},{1,3},{2,4},{3,4},{3,5},{4,5},{5,6}};
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
            Edges[y].add(new Edge(y,x,1));
        }
        
        levelOrder(Edges,0);
    }
}
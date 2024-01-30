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


    public static void DFS(ArrayList<Edge>[] graph,int root,boolean[] vis)
    {
        vis[root] = true;
        System.out.print(root+" ");

        for(Edge child : graph[root])
        {    
            if(!vis[child.dt])
            {
                DFS(graph,child.dt,vis);
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
        boolean[] visited = new boolean[N];
        Arrays.fill(visited,false);
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
        
        DFS(Edges,0,visited);
    }
}
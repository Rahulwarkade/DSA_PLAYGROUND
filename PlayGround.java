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


    public static void dfs(ArrayList<Edge>[] graph,boolean[] vis,int src)
    {
        vis[src] = true;

        for(Edge child : graph[src])
        {    
            if(!vis[child.dt])
            {
                dfs(graph,vis,child.dt);
            }
        }
    }
    public static void main(String args[])
    {
        int N  = 9;
        // int[][] edges = {{0,1},{1,2},{1,3},{2,3},{2,4}};
        int[][] edges = {{0,1},{0,2},{1,3},{2,4},{3,4},{3,5},{4,5},{5,6},{7,8}};
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
        
        int cc = 0;
        for(int i=0; i<N; i++)
        {
            if(!visited[i])
            {
                dfs(Edges,visited,i);
                cc++;
            }
        }

        System.out.println("Connected Components = "+cc);
    }
}
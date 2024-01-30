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

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean[] vis,int src,int par)
    {
        vis[src] = true;
        System.out.print(src+" ");
        for(Edge child : graph[src])
        {
            if(vis[child.dt] && child.dt!=par)
                return true;
            if(!vis[child.dt] && detectCycleUtil(graph,vis,child.dt,src))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph,boolean[] vis)
    {
        
        for(int i=0; i<graph.length; i++)
        {
            if(!vis[i] && detectCycleUtil(graph,vis,i,-1))
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        int N  = 5;
        // int[][] edges = {{0,1},{1,2},{1,3},{2,3},{2,4}};
        int[][] edges = {{0,1},{0,2},{1,3},{2,4}};
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

        System.out.println(detectCycle(Edges,visited));
    }
}
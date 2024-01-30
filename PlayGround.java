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

    public static boolean bipartiteUtil(ArrayList<Edge>[] graph,int[] col,int src)
    {
        Queue<Integer> q = new LinkedList<>();
        col[src] = 0;
        q.add(src);

        while(!q.isEmpty())
        {
            int node = q.remove();

            for(Edge child : graph[node])
            {
                if(col[child.dt]==-1)
                {
                    int newCol = col[node]==0?1 : 0;
                    col[child.dt] = newCol;
                    q.add(child.dt);
                }
                else if(col[child.dt]==col[node])
                {
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean bipartite(ArrayList<Edge>[] graph)
    {
        int col[] = new int[graph.length];
        Arrays.fill(col,-1);
        for(int i=0; i<graph.length; i++)
        {
            if(col[i]==-1)
            {
                if(!bipartiteUtil(graph,col,i))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        int N  = 5;
        // int[][] edges = {{0,1},{1,2},{1,3},{2,3},{2,4}};
        int[][] edges = {{0,1},{0,2},{1,3},{2,4},{3,4}};
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

        System.out.println(bipartite(Edges));
    }
}
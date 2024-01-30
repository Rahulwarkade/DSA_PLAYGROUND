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

    public static void topSortUtil(ArrayList<Edge>[] graph,boolean[] vis,Stack<Integer> st,int src)
    {
        vis[src] = true;

        for(Edge child : graph[src])
        {
            if(!vis[child.dt])
            {
                topSortUtil(graph,vis,st,child.dt);
            }
        }
        st.push(src);
    }
    public static void topSort(ArrayList<Edge>[] graph)
    {
        int N = graph.length;
        boolean[] visited = new boolean[N];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<N; i++)
        {
            if(!visited[i])
            {
                topSortUtil(graph,visited,st,i);
            }
        }

        while(!st.isEmpty())
        {
            System.out.print(st.pop()+" ");
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

        topSort(Edges);
    }
}
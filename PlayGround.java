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
        public int compareTo(Pair obj)
        {
            return this.wt-obj.wt;
        }
    }

    public static void connectingCities(int[][] cities,int source)
    {
        boolean[] vis = new boolean[cities.length];
        Arrays.fill(vis,false);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source,0));
        int ans = 0;
        while(!pq.isEmpty())
        {
            Pair node = pq.remove();
            if(vis[node.v]) continue;
            vis[node.v] = true;
            ans+= node.wt;
            for(int i=0; i<cities[node.v].length; i++)
            {
                if(cities[node.v][i]!=0)
                {
                    int v = i;
                    int wt = cities[node.v][i];
                    pq.add(new Pair(v,wt));
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String args[])
    {
        int N  = 3;
        int[][] cities ={{0,1,2,3,4},
                         {1,0,5,0,7},
                         {2,5,0,6,0},
                         {3,0,6,0,0},
                         {4,7,0,0,0}};

        connectingCities(cities,0);
    }
}
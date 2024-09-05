import java.util.*;

public class Java_PlayGround
{

    public static class Edge implements Comparable<Edge>
    {
        int cost;
        int dest;
        public Edge(int cost,int dest)
        {
            this.cost = cost;
            this.dest = dest;
        }

        @Override
        public int compareTo(Edge obj2)
        {
            return this.cost - obj2.cost;
        }
    }

    public static int miniCostConnectingCity(int[][] cities)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[cities.length];
        int result = 0;
        Arrays.fill(visited,false);

        pq.add(new Edge(0,0));

        while(!pq.isEmpty())
        {
            Edge curr = pq.remove();

            if(!visited[curr.dest])
            {
                visited[curr.dest] = true;

                result += curr.cost;

                for(int i=0; i<cities[0].length; i++)
                {
                    if(cities[i][curr.dest]!=0)
                    {
                        pq.add(new Edge(cities[i][curr.dest],i));
                    }
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {

        int[][] cities = {
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };

        System.out.println(miniCostConnectingCity(cities));
    }

}

import java.util.*;

public class Java_PlayGround{

    public static class Edge implements Comparable<Edge>
    {
        int src;
        int dest;
        int weight;

        public Edge(int src,int dest,int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge vertex)
        {
            return this.weight - vertex.weight;
        }

    }
    public static void graphMap(HashMap<Integer,ArrayList<Edge>> graph)
    {
        int V,E;
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();


        for(int i=0; i<E; i++)
        {
            int x,y,z;
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            if(!graph.containsKey(x)){
                graph.put(x,new ArrayList<>());
            }
            if(!graph.containsKey(y)){
                graph.put(y,new ArrayList<>());
            }

            if(x!=y){
                graph.get(x).add(new Edge(x,y,z));
                // graph.get(y).add(new Edge(y,x,z));     
            }
        }
    }   

    public static void bfsUtil(HashMap<Integer,ArrayList<Edge>> graph,HashMap<Integer,Boolean> visited,int root)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited.put(root,true);
        while(!q.isEmpty())
        {
            int node = q.remove();
            System.out.print(node + " ");
            for(Edge child : graph.get(node))
            {
                if(!visited.get(child.dest))
                {
                    q.add(child.dest);
                    visited.put(child.dest,true);
                }
            }
        }

    }
    public static void bfs(HashMap<Integer,ArrayList<Edge>> graph)
    {
        HashMap<Integer,Boolean> visited = new HashMap<>();

        for(Integer key : graph.keySet())
        {
            visited.put(key,false);
        }
        
        for(Integer key : visited.keySet())     
        {
            if(!visited.get(key))
            {
                bfsUtil(graph,visited,key);
            }
        }   

    }

    public static class Info{
        int v;
        int cost;
        int stops;

        public Info(int v,int cost,int stops)
        {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public static int cheapestFlight(HashMap<Integer,ArrayList<Edge>> graph,int src,int dest,int K)
    {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Integer> distance = new HashMap<>();

        for(Integer key : graph.keySet())
        {
            distance.put(key,Integer.MAX_VALUE);
        }

        distance.put(src,0);
        q.add(new Info(src,0,0));

        while(!q.isEmpty())
        {
            Info curr = q.remove();

            if(curr.stops>K) break;

            for(Edge child : graph.get(curr.v))
            {
                int u = child.src;
                int v = child.dest;
                int cost = child.weight;
                int newCost = curr.cost+cost;
                if(newCost<distance.get(v) && curr.stops<=K)
                {
                    distance.put(v,newCost);
                    q.add(new Info(v,newCost,curr.stops+1));
                }
            }
        }

        if(distance.get(dest)==Integer.MAX_VALUE) return -1;

        return distance.get(dest);
    }
    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Edge>> graph = new HashMap<>();

        graphMap(graph);

        System.out.println(cheapestFlight(graph,0,3,1));

        bfs(graph);
       
    }

}

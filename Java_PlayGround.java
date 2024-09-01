import java.util.*;

public class Java_PlayGround{

    public static class Edge implements Comparable<Edge>
    {
        int node;
        int weight;

        public Edge(int node,int weight)
        {
            this.node = node;
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
                graph.get(x).add(new Edge(y,z));
            // graph.get(y).add(x);     
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
                if(!visited.get(child.node))
                {
                    q.add(child.node);
                    visited.put(child.node,true);
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

    public static void dijkstrasAlgo(HashMap<Integer,ArrayList<Edge>> graph,int source)
    {
        HashMap<Integer,Integer> distance = new HashMap<>();
        HashMap<Integer,Boolean> visited = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(Integer key : graph.keySet())
        {
            distance.put(key,Integer.MAX_VALUE);
            visited.put(key,false);
        }
        distance.put(source,0);
        pq.add(new Edge(source,0));

        while(!pq.isEmpty())
        {
            Edge vertex = pq.remove();

            if(!visited.get(vertex.node))
            {      
                System.out.println(vertex.node +" = "+distance.get(vertex.node));
                visited.put(vertex.node,true);

                for(Edge child : graph.get(vertex.node))
                {
                    int u = vertex.node;
                    int v = child.node;
                    int wt = child.weight;
                    int newDistance = distance.get(u)+wt;
                    if( newDistance < distance.get(v))
                    {
                        distance.put(v,newDistance);
                        pq.add(new Edge(v,newDistance));
                    }
                }
            }
        }




    }

    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Edge>> graph = new HashMap<>();

        graphMap(graph);

        dijkstrasAlgo(graph,0);
    }

}

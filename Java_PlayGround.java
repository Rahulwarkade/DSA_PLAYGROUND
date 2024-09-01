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

    public static void ballmenfordAlgo(HashMap<Integer,ArrayList<Edge>> graph,int source)
    {
        HashMap<Integer,Integer> distance = new HashMap<>();

        for(Integer key : graph.keySet())
        {
            distance.put(key,Integer.MAX_VALUE);
        }
        distance.put(source,0);
        int V = graph.size();

        for(int i=0; i<=V-1; i++)
        {
            for(Integer key : graph.keySet())
            {
                for(Edge child : graph.get(key))
                {
                    int u = key;
                    int v = child.node;
                    int wt = child.weight;
                    int newDistance = distance.get(u)+wt;
                    if(distance.get(u)!=Integer.MAX_VALUE && newDistance < distance.get(v))
                    {
                        distance.put(v,newDistance);
                    }
                }
            }
        }

        for(Integer key : distance.keySet())
        {
            System.out.println(key + " = "+ distance.get(key));
        }
    }

    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Edge>> graph = new HashMap<>();

        graphMap(graph);

        ballmenfordAlgo(graph,10);
       
    }

}

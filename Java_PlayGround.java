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
                graph.get(y).add(new Edge(y,x,z));     
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


    public static void primsAlgoUtil(HashMap<Integer,ArrayList<Edge>> graph,HashMap<Integer,Boolean> visited,int source)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        ArrayList<Edge> list = new ArrayList<>();

        pq.add(new Edge(source,source,0));
        int finalCost = 0;

        while(!pq.isEmpty())
        {
            Edge curr = pq.remove();

            if(!visited.get(curr.dest))
            {
                visited.put(curr.dest,true);
                list.add(new Edge(curr.src,curr.dest,curr.weight));
                finalCost += curr.weight;

                for(Edge child : graph.get(curr.dest))
                {
                    pq.add(child);
                }
            }
        }

        System.out.println(finalCost);

        for(Edge edge : list)
        {
            System.out.println(edge.src+"->"+edge.dest+" = "+edge.weight);
        }
    }
    public static void primsAlgo(HashMap<Integer,ArrayList<Edge>> graph)
    {
        HashMap<Integer,Boolean> visited = new HashMap<>();

        for(Integer key : graph.keySet())
        {
            visited.put(key,false);
        }

        primsAlgoUtil(graph,visited,10);
    }
    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Edge>> graph = new HashMap<>();

        graphMap(graph);

        primsAlgo(graph);
       
    }

}

import java.util.*;

public class Java_PlayGround{


    public static void depthFirstSearch(HashMap<Integer,ArrayList<Integer>> graph,int root,HashMap<Integer,Boolean> visited)
    {
        System.out.println(root);
        visited.put(root,true);
        for(Integer child : graph.get(root))
        {
            if(!visited.get(child))
                depthFirstSearch(graph,child,visited);
        }
    }

    public static void breadthFirstSearch(HashMap<Integer,ArrayList<Integer>> graph,int root,HashMap<Integer,Boolean> visited)
    {
        Queue<Integer> q = new LinkedList<>();
        visited.put(root,true);
        q.add(root);

        while(!q.isEmpty())
        {
            int node = q.remove();
            System.out.println(node);
            for(Integer child : graph.get(node))
            {
                if(!visited.get(child)){
                    visited.put(child,true);
                    q.add(child);
                }
            }
        }
    }
    // maping in graph
    // public static HashMap<Integer,Boolean> visited = new HashMap<>();

    public static void graphMap(HashMap<Integer,ArrayList<Integer>> graph)
    {
        int V,E;
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();


        for(int i=0; i<E; i++)
        {
            int x,y;
            x = sc.nextInt();
            y = sc.nextInt();
            if(!graph.containsKey(x)){
                graph.put(x,new ArrayList<>());
            }
            if(!graph.containsKey(y)){
                graph.put(y,new ArrayList<>());
            }

            if(x!=y){
            graph.get(x).add(y);
            graph.get(y).add(x);     
            }
        }
    }

    public static boolean hashPath(HashMap<Integer,ArrayList<Integer>> graph,HashMap<Integer,Boolean> visited,int src,int dest)
    {
        if(src==dest)
        {
            return true;
        }
        visited.put(src,true);

        for(Integer child : graph.get(src))
        {
            if(!visited.get(child))
            {
                if(hashPath(graph,visited,child,dest))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
    HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

    graphMap(graph);
    HashMap<Integer,Boolean> visited = new HashMap<>();

    for(Integer keys : graph.keySet())
    {
        visited.put(keys,false);
    }

    System.out.println("Hash a path = "+hashPath(graph,visited,20,24));
    }
}

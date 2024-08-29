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
    // maping in graph
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

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

    }
    public static void main(String[] args) {
    HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

    graphMap(graph);

    HashMap<Integer,Boolean> visited = new HashMap<>();

    for(Integer keys : graph.keySet())
    {
        visited.put(keys,false);
    }

    depthFirstSearch(graph,20,visited);
    }
}

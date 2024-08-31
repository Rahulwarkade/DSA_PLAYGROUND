import java.util.*;

public class Java_PlayGround{


    public static boolean cycleDetectionUtil(HashMap<Integer,ArrayList<Integer>> graph,int root,HashMap<Integer,Boolean> visited,int parent)
    {
        System.out.println(root);
        visited.put(root,true);
        for(Integer child : graph.get(root))
        {
            if(!visited.get(child)){
                if(cycleDetectionUtil(graph,child,visited,root)) return true;
            }
            else if(visited.get(child) && child!=parent) {
                System.out.print(child + " " + parent);
                return true;
            }
        }
        return false;
    }


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


    public static boolean cycleDetection(HashMap<Integer,ArrayList<Integer>> graph)
    {
        HashMap<Integer,Boolean> visited = new HashMap<>();

        for(Integer keys : graph.keySet())
        {
            visited.put(keys,false);
        }

        for(Integer key : graph.keySet())
        {
            if(!visited.get(key))
            {
                if(cycleDetectionUtil(graph,key,visited,-1)) return true;
            }
        }
        return false;
 
    }

    public static void main(String[] args) {
    HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

    graphMap(graph);

        System.out.println("Cycle exits = "+ cycleDetection(graph));

    }

}

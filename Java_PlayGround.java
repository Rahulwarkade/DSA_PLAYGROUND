import java.util.*;

public class Java_PlayGround{

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
            // graph.get(y).add(x);     
            }
        }
    }

    public static boolean isCycleUtil(HashMap<Integer,ArrayList<Integer>> graph,HashMap<Integer,Boolean> visited,HashMap<Integer,Boolean> stack,int root)
    {
        visited.put(root,true);
        stack.put(root,true);

        for(Integer child : graph.get(root))
        {
            if(!visited.get(child))
            {
                if(isCycleUtil(graph,visited,stack,child)) return true;
            }
            else if(visited.get(child) && stack.get(child))
            {
                return true;
            }
        }
        stack.put(root,false);
        return false;
    }

    public static boolean isCycle(HashMap<Integer,ArrayList<Integer>> graph)
    {
        HashMap<Integer,Boolean> visited = new HashMap<>();
        HashMap<Integer,Boolean> stack = new HashMap<>();
        for(Integer key : graph.keySet())
        {
            visited.put(key,false);
            stack.put(key,false);
        }

        for(Integer key : visited.keySet())
        {
            if(!visited.get(key))
            {
                if(isCycleUtil(graph,visited,stack,key)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

        graphMap(graph);

        System.out.println("Cycle detected = "+ isCycle(graph));

    }

}

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

    public static void topSortUtil(HashMap<Integer,ArrayList<Integer>> graph,HashMap<Integer,Boolean> visited,Stack<Integer> st,int root)
    {
        visited.put(root,true);
        for(Integer child : graph.get(root))
        {
            if(!visited.get(child))
            {
                topSortUtil(graph,visited,st,child);
            }
        }
        st.push(root);
    }
    public static void topSort(HashMap<Integer,ArrayList<Integer>> graph)
    {
        HashMap<Integer,Boolean> visited = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(Integer key : graph.keySet())
        {
            visited.put(key,false);
        }

        for(Integer key : visited.keySet())
        {
            if(!visited.get(key))
            {
                topSortUtil(graph,visited,st,key);
            }
        }

        while(!st.isEmpty())
        {
            System.out.println(st.pop());
        }
    }

    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

        graphMap(graph);

        topSort(graph);

    }

}

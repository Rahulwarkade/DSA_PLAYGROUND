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

    public static void indgreeUtil(HashMap<Integer,ArrayList<Integer>> graph,HashMap<Integer,Integer> indgree)
    {
        for(Integer key : graph.keySet())
        {
            indgree.put(key,0);
        }

        for(Integer key : graph.keySet())
        {
            for(Integer child : graph.get(key))
            {
                indgree.put(child,indgree.get(child)+1);
            }
        }

    }
    public static void topSort(HashMap<Integer,ArrayList<Integer>> graph)
    {
        HashMap<Integer,Integer> indgree = new HashMap<>();
        indgreeUtil(graph,indgree);

        Queue<Integer> q = new LinkedList<>();
        for(Integer val : indgree.keySet())
        {
            if(indgree.get(val)==0)
            {
                q.add(val);
            }
        }

        while(!q.isEmpty())
        {
            int vertex = q.remove();
            System.out.println(vertex);
            for(Integer child : graph.get(vertex))
            {
                indgree.put(child,indgree.get(child)-1);
                if(indgree.get(child)==0)
                {
                    q.add(child);
                }
            }
        }
    }
    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

        graphMap(graph);

        topSort(graph);

    }

}

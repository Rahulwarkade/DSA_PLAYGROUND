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

    public static void getAllPathUtil(HashMap<Integer,ArrayList<Integer>> graph,int src,int dest, ArrayList<Integer> path)
    {
        path.add(src);
        if(src == dest)
        {
            for(Integer value : path)
                System.out.print(value+" ");
            System.out.println();
            return;
        }

        for(Integer child : graph.get(src))
        {
            getAllPathUtil(graph,child,dest,path);
            path.remove(path.size()-1);
        }
    }

    public static void getAllPath(HashMap<Integer,ArrayList<Integer>> graph)
    {
        int src = 50;
        int dest = 24;
        ArrayList<Integer> path = new ArrayList<>();

        getAllPathUtil(graph,src,dest,path);
    }
    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

        graphMap(graph);

        getAllPath(graph);

    }

}

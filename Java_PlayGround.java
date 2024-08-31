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
            graph.get(y).add(x);     
            }
        }
    }

    public static boolean bipartite(HashMap<Integer,ArrayList<Integer>> graph)
    {
        HashMap<Integer,Integer> color = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(Integer key : graph.keySet())
        {
            color.put(key,-1);
        }

        for(Integer key : color.keySet())
        {
            if(color.get(key)==-1)
            {
                q.add(key);
                color.put(key,0);

                while(!q.isEmpty())
                {
                    int curr = q.remove();

                    for(Integer child : graph.get(curr))
                    {
                        if(color.get(child)==-1)
                        {
                            int nextColor = (color.get(curr)==0)?1 : 0;
                            color.put(child,nextColor);
                            q.add(child);
                        }
                        else if(color.get(child)==color.get(curr))
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

    graphMap(graph);

        System.out.println("Graph is bipartite = "+ bipartite(graph));

    }

}

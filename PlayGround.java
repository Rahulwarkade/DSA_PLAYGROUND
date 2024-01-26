import java.util.*;

public class PlayGround
{  
    public static String getStart(HashMap<String,String> from)
    {
        HashSet<String> to = new HashSet<>();

        Iterator it = from.keySet().iterator();

        while(it.hasNext())
        {
            to.add(from.get(it.next().toString()));
        }

        for(String key : from.keySet())
        {
            if(!to.contains(key)) return key;
        }
        return "start";
    }
    public static void main(String args[])
    {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai","Bengaluru");   
        tickets.put("Mumbai","Delhi");   
        tickets.put("Goa","Chennai");   
        tickets.put("Delhi","Goa");   

        String start = getStart(tickets);
        System.out.print(start);

        for(String key : tickets.keySet())
        {
            System.out.print("->"+tickets.get(start));
            start = tickets.get(start);
        }
    }
}
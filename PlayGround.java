import java.util.*;

public class PlayGround
{  
    public static class Soldier implements Comparable<Soldier>
    {
        int count;
        int idx;
        public Soldier(int count,int idx)
        {
            this.count = count;
            this.idx = idx;
        }

        @Override
        public int compareTo(Soldier o2)
        {
            if(this.count==o2.count)
            {
                return this.idx - o2.idx;
            }
            return this.count - o2.count;
        }
    }
    public static void main(String args[])
    {
        int[][] soldiers = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k = 2;
        PriorityQueue<Soldier> pq = new PriorityQueue<>();

        for(int i=0; i<soldiers.length; i++)
        {
            int count =0;
            for(int j=0; j<soldiers[0].length; j++)
            {
                count += (soldiers[i][j]==1)?1 :0;
            }
            pq.add(new Soldier(count,i));
        }

        for(int i=0; i<k; i++)
        {
            System.out.println("R"+pq.remove().idx);
        }
     
    }
}
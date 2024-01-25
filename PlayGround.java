import java.util.*;

public class PlayGround
{  
    public static class Point implements Comparable<Point>
    {
        int x;
        int y;
        int dist;
        int idx;
        public Point(int x,int y,int dist,int idx)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point obj2)
        {
            return this.dist - obj2.dist;
        }
    }
    public static void main(String args[])
    {
        int[][] arr = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++)
        {
            int x= arr[i][0];
            int y = arr[i][1];
            int dist = x*x + y*y;
            pq.add(new Point(x,y,dist,i));
        }

        for(int i=0; i<k; i++)
            System.out.println("C"+pq.remove().idx);
    }
}
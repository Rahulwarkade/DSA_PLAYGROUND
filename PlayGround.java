import java.util.*;

public class PlayGround
{
    public static int chocola(Integer[] hor,Integer[] ver)
    {
        int n = hor.length;
        int m = ver.length;
        Arrays.sort(hor,Comparator.reverseOrder());
        Arrays.sort(ver,Comparator.reverseOrder());
        int hc =0,vc=0;
        int hp =1,vp =1;
        int cost = 0;
        while(hc<n && vc<m)
        {
            if(hor[hc]>ver[vc])
            {
                cost += (hor[hc]*hp);
                hc++;
                vp++;
            }else{
                cost += (ver[vc]*vp);
                vc++;
                hp++;
            }
        }
        while(hc<n)
        {
            cost += (hor[hc]*hp);
            hc++;
            vp++;
        }
        while(vc<m)
        {
            cost += (ver[vc]*vp);
            vc++;
            hp++;
        }
        return cost;
    }
    public static void main(String args[])
    {
       Integer[] horizontalcuts = {4,3,2,1,1};
       Integer[] verticalcuts = {4,2,1};

       System.out.println(chocola(horizontalcuts,verticalcuts));
    }
}
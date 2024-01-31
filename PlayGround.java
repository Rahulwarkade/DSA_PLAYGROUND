import java.util.*;

public class PlayGround
{  
 
    public static void floodFillUtil(int[][] image,int sr,int sc,int newCol,int orgCol,boolean[][] vis)
    {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc]!=orgCol) return;
        image[sr][sc] = newCol;
        vis[sr][sc] = true;

        floodFillUtil(image,sr-1,sc,newCol,orgCol,vis);
        floodFillUtil(image,sr+1,sc,newCol,orgCol,vis);
        floodFillUtil(image,sr,sc-1,newCol,orgCol,vis);
        floodFillUtil(image,sr,sc+1,newCol,orgCol,vis);
    }
    public static int[][] floodFill(int[][] image,int sr,int sc,int newCol)
    {
        boolean[][] vis = new boolean[image.length][image[0].length];
        for(int i=0; i<vis.length; i++)
            Arrays.fill(vis[i],false);
        
        floodFillUtil(image,sr,sc,newCol,image[sr][sc],vis);

        return image;
    }
    public static void main(String args[])
    {
        int[][] image = {{1,1,1},
                             {1,1,0},
                             {1,0,1}};

        image = floodFill(image,1,1,2);

        for(int i=0; i<image.length; i++)
        {
            for(int j=0; j<image[i].length; j++)
                System.out.print(image[i][j]+" ");
            System.out.println();
        }
    }
}
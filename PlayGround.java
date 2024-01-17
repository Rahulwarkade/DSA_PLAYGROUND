import java.util.*;

public class PlayGround
{
    public static void printArr(int[][] arr)
    {
        int n = arr.length,m = arr[0].length;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        int n = end.length;
        int[][] activities = new int[n][3];

        for(int i=0; i<n; i++)
        {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities,Comparator.comparingInt(row -> row[2]));

        ArrayList<String> ans = new ArrayList<>();
        ans.add("A"+activities[0][0]);
        int endTime = activities[0][2];
        for(int i=1; i<n; i++)
        {
            int startTime = activities[i][1];
            if(endTime<=startTime)
            {
                ans.add("A"+activities[i][0]);
                endTime = activities[i][2];
            }
        }

        System.out.println(ans.size());

        for(String str : ans)
        {
            System.out.println(str);
        }
        
    }
}
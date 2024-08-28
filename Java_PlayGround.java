import java.util.*;

public class Java_PlayGround{

    public static void printGraph(int[][] graph)
    {
        for(int i=0; i<graph.length; i++)
        {
            for(int j=0; j<graph[0].length; j++)
                System.out.print(graph[i][j]+ " ");
            System.out.println();
        }

    }

    public static int N = 70;
    public static int[][] graph = new int[N+1][N+1];
    // matrix
    // Space Complexity = O(N*N)
    public static void graphMatrix()
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
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        graphMatrix();

        printGraph(graph);
    }
}

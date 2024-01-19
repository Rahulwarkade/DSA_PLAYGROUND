import java.util.*;

public class PlayGround
{
    public static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int idx = -1;
    public static Node buildTree(int[] arr)
    {
        idx++;
        if(arr[idx]==-1)
        {
            return null;
        }

        Node newNode = new Node(arr[idx]);
        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);
        return newNode;
    }
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

    public static void preOrder(Node root)
    {
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root)
    {
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void inOrder(Node root)
    {
        if(root==null)return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void levelOrder(Node root)
    {
        Queue<Node> que = new LinkedList<>();

        que.add(root);
        que.add(null);
        while(!que.isEmpty())
        {
            Node node = que.remove();
            if(node==null)
            {
                System.out.println();
                if(que.isEmpty()) break;
                else que.add(null);
            }
            else{
                System.out.print(node.data+" ");
                if(node.left!=null)
                    que.add(node.left);
                if(node.right!=null)
                    que.add(node.right);
            }
        }
    }

    public static int maxChainLen(int[][] pairs)
    {
        Arrays.sort(pairs,Comparator.comparingInt(row->row[1]));
        int ans = 1;
        int endTime = pairs[0][1];
        for(int i=1; i<pairs.length; i++)
        {
            int startTime = pairs[i][0];
            if(endTime<=startTime)
            {
                ans++;
                endTime = pairs[i][1];
            }
        }
        return ans;
    }
    public static int minCoins(Integer[] coins,int amount)
    {
        Arrays.sort(coins, Comparator.reverseOrder());
        

        int minCoin = 0;
        for(int i=0; i<coins.length; i++)
        {
            if(coins[i]<=amount)
            {
                while(coins[i]<=amount)
                {
                    amount-=coins[i];
                    minCoin++;
                }
            }
        }
        return minCoin;
    }
    public static void main(String args[])
    {
       Integer[] coins = {2,50,1,500,20,10,5,2000,100};

       System.out.println(minCoins(coins,590));
    }
}
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

    public static Node root;
    public static int idx = -1;

    public static Node buildBT(int[] tree)
    {
        idx++;
        if(tree[idx]==-1) return null;
        Node node = new Node(tree[idx]);
        node.left = buildBT(tree);
        node.right = buildBT(tree);
        return node;
    }

    public static class Info
    {
        boolean isbst;
        int size;
        int max;
        int min;
        public Info(boolean isbst,int size,int max,int min)
        {
            this.isbst = isbst;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
    public static void inOrder(Node root)
    {
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void preOrder(Node root)
    {
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static int bstSize = 0;
    public static Info largestBST(Node root)
    {   
        if(root == null ) return new Info(true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);

        Info leftinfo = largestBST(root.left);
        Info rightinfo = largestBST(root.right);
        int size = leftinfo.size + rightinfo.size +1;
        int min = Math.min(root.data,Math.min(leftinfo.min,rightinfo.min));
        int max = Math.max(root.data,Math.max(leftinfo.max,rightinfo.max));

        if(root.data<leftinfo.max || root.data>rightinfo.min)
        {
            return new Info(false,size,max,min);
        }
        if(leftinfo.isbst && rightinfo.isbst)
        {
            bstSize = Math.max(bstSize,size);
            return new Info(true,size,max,min);
        }

        return new Info(false,size,max,min);
        
    }
    public static void main(String args[])
    {
        int[] tree = {50,30,5,-1,-1,20,-1,-1,60,45,-1,-1,70,65,-1,-1,80,-1,-1};

        root = buildBT(tree);
        largestBST(root);
        System.out.println(bstSize);
        preOrder(root);
    }
}
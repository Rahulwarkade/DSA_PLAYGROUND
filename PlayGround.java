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
    public static Node buildTree(int[] arr)
    {
        idx++;
        if(arr[idx]==-1) return null;

        Node newNode = new Node(arr[idx]);
        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);

        return newNode;
    }

    public static void preOder(Node node)
    {
        if(node==null) return;

        System.out.print(node.data+" ");
        preOder(node.left);
        preOder(node.right);
    }

    public static void kthLevelOfTree(Node node,int level,int k)
    {
        if(node==null) return;

        if(level==k)
        {
            System.out.print(node.data+" ");
            return;
        }
        kthLevelOfTree(node.left,level+1,k);
        kthLevelOfTree(node.right,level+1,k);
    }
    public static void main(String args[])
    {
        int[] tree = {1,2,3,-1,-1,4,-1,-1,6,5,-1,-1,7,-1,-1};

        root = buildTree(tree);

        kthLevelOfTree(root,1,3);
    }
}
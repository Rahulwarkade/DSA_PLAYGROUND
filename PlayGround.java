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

    public static int transformToSumTree(Node node)
    {
        if(node==null) return 0;

        int leftchild = transformToSumTree(node.left);
        int rightchild = transformToSumTree(node.right);
        int data = node.data;
        int newLeft = node.left!=null?node.left.data : 0;
        int newRight = node.right!=null?node.right.data : 0;
        node.data = leftchild+rightchild+newLeft+newRight;
        return data;
    }
    public static void preOrder(Node node)
    {
        if(node==null) return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String args[])
    {
        int[] tree = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

        root = buildTree(tree);

        transformToSumTree(root);

        preOrder(root);
    }
}
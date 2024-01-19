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
    public static void inOrder(Node node)
    {
        if(node==null) return;

        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    public static class Info
    {
        int diameter;
        int height;
        public Info(int height,int diameter)
        {
            this.height = height;
            this.diameter = diameter;
        }
    }
    public static Info diameterOfTree(Node node)
    {
        if(node == null)
        {
            return new Info(0,0);
        }

        Info leftInfo = diameterOfTree(node.left);
        Info rightInfo = diameterOfTree(node.right);

        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        int selfdiameter = leftInfo.height + rightInfo.height +1;
        int diameter = Math.max(selfdiameter,Math.max(leftInfo.diameter,rightInfo.diameter));

        return new Info(height,diameter);
    }
    public static void main(String args[])
    {
        int[] arr = {1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};

        root = buildTree(arr);
        preOder(root);
        System.out.println();
        System.out.println("Diameter of A Tree is = " + diameterOfTree(root).diameter);
    }
}
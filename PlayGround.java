// import java.util.*;

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

    public static Node insert(Node root,int data)
    {
        if(root==null)
        {
            root = new Node(data);
            return root;
        }

        if(root.data>data)
        {
            root.left = insert(root.left,data);
        }
        else
        {
            root.right = insert(root.right,data);
        }
        return root;
    }

    public static void inOrder(Node root)
    {
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean searchInBst(Node root,int ele)
    {
        if(root==null) return false;
        if(root.data==ele)
        {
            return true;
        }
        if(root.data<ele)
        {
           return searchInBst(root.right,ele);
        }
        else{
            return searchInBst(root.left,ele);
        }

    }
    public static void main(String args[])
    {
        int[] tree = {5,1,3,4,2,7};

        Node root = null;

        for(int i=0; i<tree.length; i++)
        {
            root = insert(root,tree[i]);
        }

        System.out.println("Element found = "+ searchInBst(root,4));

        inOrder(root);
    }
}
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

    public static void preOrder(Node root)
    {
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node findInOrderSuccessor(Node root)
    {
        while(root.left!=null)
        {
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root,int key)
    {
        if(root.data == key)
        {
            if(root.left == null && root.right ==null) return null;

            if(root.left==null) return root.right;

            if(root.right==null) return root.left;

            Node inOrderSuccessor = findInOrderSuccessor(root.right);
            root.data = inOrderSuccessor.data;
            root.right = delete(root.right,inOrderSuccessor.data);
        }
        else if(root.data<key)
        {
            root.right = delete(root.right,key);
        }
        else
        {
            root.left = delete(root.left,key);
        }
        return root;
    }
    public static void main(String args[])
    {
        int[] tree = {8,5,10,3,6,11,1,4,14};

        Node root = null;

        for(int i=0; i<tree.length; i++)
        {
            root = insert(root,tree[i]);
        }

        root = delete(root,8);
        preOrder(root);
        System.out.println();
        inOrder(root);
    }
}
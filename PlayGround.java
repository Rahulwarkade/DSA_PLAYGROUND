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


    public static boolean validateBST(Node root,Node min,Node max)
    {
        if(root==null) return true;

        if(min!=null && root.data<=min.data) return false;
        if(max!=null && root.data>=max.data) return false;

        return validateBST(root.left,min,root) && validateBST(root.right,root,max);
    }
    public static void main(String args[])
    {
        int[] tree = {8,5,10,3,6,11,1,4,14,8};

        Node root = null;

        for(int i=0; i<tree.length; i++)
        {
            root = insert(root,tree[i]);
        }

        inOrder(root);
        System.out.println();
        
        if(validateBST(root,null,null))
        {
            System.out.println("Valid BST");
        }else{
            System.out.println("Invalid BST");
        }
    }
}
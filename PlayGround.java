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

    public static void rootToLeaf(Node root,ArrayList<Integer> list)
    {
        if(root==null) return;
        if(root.left==null && root.right==null)
        {
            list.add(root.data);
            int n = list.size();
            for(int i=0; i<n; i++)
                System.out.print(list.get(i)+" ");
            System.out.println();
            return;
        }
        list.add(root.data);
        rootToLeaf(root.left, list);
        rootToLeaf(root.right, list);
        list.remove(list.size()-1);
    }
    public static void main(String args[])
    {
        int[] tree = {8,5,10,3,6,11,1,4,14};

        Node root = null;

        for(int i=0; i<tree.length; i++)
        {
            root = insert(root,tree[i]);
        }

        inOrder(root);
        System.out.println();
        rootToLeaf(root, new ArrayList<Integer>());
    }
}
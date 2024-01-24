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
    public static void preOrder(Node root)
    {
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void getInOrder(Node root,ArrayList<Integer> inorder)
    {
        if(root==null) return;
        getInOrder(root.left,inorder);
        inorder.add(root.data);
        getInOrder(root.right,inorder);
    }

    public static Node balancedBST(ArrayList<Integer> inorder,int si,int ei)
    {
        if(si>ei) return null;
        int mid = si+((ei-si)>>1);
        Node root = new Node(inorder.get(mid));
        root.left = balancedBST(inorder,si,mid-1);
        root.right = balancedBST(inorder,mid+1,ei);
        return root;
    }
    public static void main(String args[])
    {
        int[] tree = {3,5,6,8,10,11,12};

        Node root = null;

        for(int i=0; i<tree.length; i++)
        {                                                        
            root = insert(root,tree[i]);
        }

        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(root,inorder);
        root = balancedBST(inorder,0,inorder.size()-1);
    }
}
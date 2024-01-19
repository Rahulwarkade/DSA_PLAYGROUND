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

    public static boolean isIdentical(Node root1, Node subroot)
    {
        if(root1==null && subroot == null)
        {
            return true;
        }else if(root1==null || subroot==null || root1.data!=subroot.data)
        {
            return false;
        }
        if(!isIdentical(root1.left, subroot.left))
        {
            return false;
        }
        if(!isIdentical(root1.right, subroot.right))
        {
            return false;
        }
        return true;
    }

    public static boolean isSubTree(Node root1,Node subroot)
    {
        if(root1==null) return false;
        
        if(root1.data == subroot.data)
        {
            if(isIdentical(root1,subroot)) return true;
        }
        return isSubTree(root1.left, subroot) || isSubTree(root1.right, subroot);
    }
    public static void main(String args[])
    {
        int[] tree = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int[] subtree = {2,4,-1,-1,5,-1,-1};
        root = buildTree(tree);
        idx = -1;
        Node subroot = buildTree(subtree);
        preOder(root);
        System.out.println();
        preOder(subroot);
        System.out.println();
        System.out.println("Subtree of another Tree = " + isSubTree(root, subroot));
    }
}
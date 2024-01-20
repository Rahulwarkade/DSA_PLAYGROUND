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

    public static Node lca(Node node,int n1,int n2)
    {
        if(node==null || node.data==n1 || node.data==n2) return node;

        Node leftlca = lca(node.left,n1,n2);
        Node rightlca = lca(node.right,n1,n2);

        if(leftlca==null) return rightlca;
        if(rightlca==null) return leftlca;
        
        return node;
    }
    public static int kthAnc = -1;
    public static int kthAncestor(Node node, int value, int k)
    {
        if(node==null) return -1;
        if(node.data==value) return 0;
        int leftAncestor = kthAncestor(node.left, value,k);
        int rightAncestor = kthAncestor(node.right, value,k);
        if(leftAncestor!=-1)
        {
            if(leftAncestor+1==k)
            {
                kthAnc = node.data;
            }
        }
        if(rightAncestor!=-1)
        {
            if(rightAncestor+1==k)
            {
                kthAnc = node.data;
            }
        }
        return kthAnc;
    }
    public static void main(String args[])
    {
        int[] tree = {1,2,3,-1,-1,4,-1,-1,6,5,-1,-1,7,-1,-1};

        root = buildTree(tree);

        System.out.println("Min Distance b/w Nodes = "+ kthAncestor(root, 5, 1));
    }
}
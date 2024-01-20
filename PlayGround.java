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
    public static int dist(Node ancestor,int n)
    {
        if(ancestor==null) return -1;
        if(ancestor.data==n) return 0;

        int leftdist = dist(ancestor.left,n);
        int rightdist = dist(ancestor.right,n);
        if(leftdist!=-1)
        {
            return leftdist+1;
        }
        if(rightdist!=-1){
            return rightdist+1;
        }
        return -1;
    }
    public static int minDist(Node node,int n1,int n2)
    {
        if(node==null) return -1;
        Node ancestor = lca(node,n1,n2);

        return dist(ancestor,n1)+dist(ancestor,n2);
    }
    public static void main(String args[])
    {
        int[] tree = {1,2,3,-1,-1,4,-1,-1,6,5,-1,-1,7,-1,-1};

        root = buildTree(tree);

        System.out.println("Min Distance b/w Nodes = "+ minDist(root,4,5));
    }
}
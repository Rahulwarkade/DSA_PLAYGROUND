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

    public static boolean getPath(Node node, int n,ArrayList<Integer> path)
    {
        if(node==null) return false;
        path.add(node.data);
        if(node.data == n) return true;
        boolean lp = getPath(node.left,n,path);
        boolean rp = getPath(node.right,n,path);
        if(lp || rp) return true;

        path.remove(path.size()-1);
        return false;
    }
    public static int lca(Node node,int a,int b)
    {
        if(node==null) return -1;
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        getPath(node,a,path1);
        getPath(node,b,path2);
        int n = Math.min(path1.size(),path2.size());
        int i = 0;
        for(; i<n; i++)
        {
            if(path1.get(i)!=path2.get(i))
                break;
        }

        return path1.get(i-1);
    }
    public static void main(String args[])
    {
        int[] tree = {1,2,3,-1,-1,4,-1,-1,6,5,-1,-1,7,-1,-1};

        root = buildTree(tree);

        System.out.println("Lowest Common Ancestor = "+ lca(root,4,3));
    }
}
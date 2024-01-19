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

    public static class Info
    {
        Node node;
        int horidistance;
        public Info(Node node,int hd)
        {
            this.node = node;
            horidistance = hd;
        }
    }

    public static void topViewOfTree(Node node)
    {
        Queue<Info> q = new LinkedList<Info>();
        HashMap<Integer,Node> map = new HashMap<>();
        q.add(new Info(node,0));
        int min= Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty())
        {
            Info currNode = q.remove();
            if(currNode.node==null){
                break;
            }
            int hd = currNode.horidistance;
            if(!(map.containsKey(hd)))
            {
                map.put(currNode.horidistance,currNode.node);
            }

            if(currNode.node.left!=null){
                q.add(new Info(currNode.node.left,currNode.horidistance-1));
                min = Math.min(min,currNode.horidistance-1);
            }
            if(currNode.node.right!=null){
                q.add(new Info(currNode.node.right,currNode.horidistance+1));
                max = Math.max(max,currNode.horidistance+1);
            }
        }

        for(int i=min; i<=max; i++)
        {
            System.out.print(map.get(i).data+" ");
        }
    }
    public static void main(String args[])
    {
        int[] tree = {1,2,3,-1,-1,4,-1,-1,6,5,-1,-1,7,-1,-1};

        root = buildTree(tree);

        topViewOfTree(root);
    }
}
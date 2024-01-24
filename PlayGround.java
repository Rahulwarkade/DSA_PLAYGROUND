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

    public static ArrayList<Integer> merge(ArrayList<Integer> list1,ArrayList<Integer> list2)
    {
        ArrayList<Integer> sorted = new ArrayList<>();
        int i =0;
        int j = 0;
        while(i<list1.size() && j<list2.size()){

            if((list1.get(i)<list2.get(j))){
                sorted.add(list1.get(i++));
            }
            else{
                sorted.add(list2.get(j++));
            }
        }
        while(i<list1.size()) {
            sorted.add(list1.get(i++));
        }
        while(j<list2.size()) 
        {
            sorted.add(list2.get(j++));
        }
        return sorted;
    }
    public static void main(String args[])
    {
        int[] tree = {1,2,4};
        int[] tree2 = {9,3,12};

        Node root = null;
        Node root2 = null;

        for(int i=0; i<tree.length; i++)
        {                                                        
            root = insert(root,tree[i]);
        }
        for(int i=0; i<tree2.length; i++)
        {                                                        
            root2 = insert(root2,tree2[i]);
        }

        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> inorder2 = new ArrayList<>();
        getInOrder(root,inorder);
        getInOrder(root2,inorder2);

        ArrayList<Integer> sorted = merge(inorder,inorder2);
        root = balancedBST(sorted,0,sorted.size()-1);
        System.out.println();
        preOrder(root);
    }
}
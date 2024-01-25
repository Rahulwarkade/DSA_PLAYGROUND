import java.util.*;

public class PlayGround
{
    public static class Node
    {
        int data;
        int height;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    public static Node root;
    public static void preOrder(Node head)
    {
        if(head==null) return;
        System.out.print(head.data+" ");
        preOrder(head.left);
        preOrder(head.right);
    }
    public static int height(Node head)
    {
        if(head==null) return 0;
        return head.height;
    }

    public static int getBalanceFactor(Node head)
    {
        if(head==null) return 0;
        return height(head.left) - height(head.right);
    }
    public static Node rightRotation(Node x)
    {
        Node y = x.left;
        Node t2 = y.right;

        y.right = x;
        x.left = t2;

        x.height = Math.max(height(x.left),height(x.right)) +1;
        y.height = Math.max(height(y.left),height(y.right)) +1;

        return y;
    }

    public static Node leftRotation(Node x)
    {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left),height(x.right))+1;
        y.height = Math.max(height(y.left),height(y.right))+1;

        return y;
    }
    public static Node insertInAVL(Node head,int key)
    {
        if(head == null)
        {
            return new Node(key);
        }

        if(key<head.data)
        {
            head.left = insertInAVL(head.left,key);
        }
        else if(key>head.data)
        {
            head.right = insertInAVL(head.right,key);
        }
        else{
            return head;
        }

        head.height = Math.max(height(head.left),height(head.right)) + 1;

        int bf = getBalanceFactor(head);

        if(bf>1 && key<head.left.data)
        {
            return rightRotation(head);
        }
        if(bf>1 && key>head.left.data)
        {
            head.left = leftRotation(head.left);
            return rightRotation(head);
        }
        if(bf<-1 && key>head.right.data)
        {
            return leftRotation(head);
        }
        if(bf<-1 && key<head.right.data)
        {
            head.right = rightRotation(head.right);
            return leftRotation(head);
        }

        return head;
    }
    public static void main(String args[])
    {
        int[] avltree = {10,20,30,40,50,25};

        for(int i=0; i<avltree.length; i++)
        {
            root = insertInAVL(root,avltree[i]);
        }

        preOrder(root);
    }
}
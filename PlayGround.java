import java.util.*;

public class PlayGround
{  
    public static class Node 
    {
        Node[] children = new Node[26];
        boolean eow  = false;
        public Node()
        {
            for(int i=0; i<26; i++)
                this.children[i] = null;
        }
    }

    public static Node root = new Node();

    public static void insert(String word)
    {
        Node temp = root;
        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(temp.children[idx]==null)
            {
                temp.children[idx] = new Node();
            }
            temp = temp.children[idx];
        }
        temp.eow = true;
    }

    public static boolean search(String word)
    {
        Node temp = root;

        for(int i=0; i<word.length(); i++)
        {
            int idx = word.charAt(i) - 'a';
            if(temp.children[idx]==null)
            {
                return false;
            }
            temp = temp.children[idx];
        }

        return temp.eow;
    }

    public static int uniqueSubstr(Node temp)
    {
        if(temp==null) return 0;

        int nodes = 0;
        for(int i=0; i<temp.children.length; i++)
        {
            if(temp.children[i]!=null)
            {
                nodes += uniqueSubstr(temp.children[i]);
            }
        }
        return nodes+1;
    }
    public static void main(String args[])
    {
        String str = "ababa";
        for(int i=0; i<str.length(); i++)
        {
            insert(str.substring(i));
        }

        System.out.println("Unique Substrings = "+uniqueSubstr(root));
    }
}
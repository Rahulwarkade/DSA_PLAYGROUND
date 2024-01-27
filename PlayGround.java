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

    public static boolean wordBreak(String key)
    {
        if(key.length() == 0) return true;

        for(int i=1; i<=key.length(); i++)
        {
            if(search(key.substring(0,i)) && wordBreak(key.substring(i)))
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        String[] words = {"i","like","sam","samsung","mobile","ice"};
        String key = "ilikesamsung";
        for(int i=0; i<words.length; i++)
        {
            insert(words[i]);
        }

        System.out.println(wordBreak(key));
    }
}
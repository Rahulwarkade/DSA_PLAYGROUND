import java.util.*;

public class PlayGround
{  
    public static class Node 
    {
        Node[] children = new Node[26];
        boolean eow  = false;
        int freq = 1;
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
            else{
                temp.children[idx].freq++;
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


    public static void shortestPrefix(Node temp, String ans)
    {
        if(temp == null)
        {
            return;
        }

        if(temp.freq==1)
        {
            System.out.println(ans);
            return;
        }
        for(int i=0; i<26; i++)
        {
            if(temp.children[i]!=null)
            {
                shortestPrefix(temp.children[i],ans + (char)(i+'a'));
            }
        
        }
    }
    public static void main(String args[])
    {
        String[] words = {"zebra","dog","duck","dove"};

        for(int i=0; i<words.length; i++)
        {
            insert(words[i]);
        }
        root.freq = -1;
        shortestPrefix(root,"");
    }
}
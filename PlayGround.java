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


    public static void main(String args[])
    {
        String[] words = {"the","a","there","their","any","thee"};

        for(int i=0; i<words.length; i++)
        {
            insert(words[i]);
        }

    }
}
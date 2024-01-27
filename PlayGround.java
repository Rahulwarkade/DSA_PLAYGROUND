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
    public static String longword = "";
    public static void longestWord(Node temp, StringBuilder ans)
    {
        if(temp==null) return;

        for(int i=0; i<26; i++)
        {
            if(temp.children[i]!=null && temp.children[i].eow==true)
            {
                char ch = (char)(i+'a');
                ans.append(ch);
                if(ans.length()>longword.length())
                {
                    longword = ans.toString();
                }
                longestWord(temp.children[i],ans);
                ans.deleteCharAt(ans.length()-1);
            }
        }
    }
    public static void main(String args[])
    {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        for(int i=0; i<words.length; i++)
        {
            insert(words[i]);
        }
        longestWord(root,new StringBuilder(""));
        System.out.println("Longest word = "+longword);
    }
}
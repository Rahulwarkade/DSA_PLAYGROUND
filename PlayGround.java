import java.util.*;

public class PlayGround
{  
    public static class HashMap<K,V>
    {
        private class Node
        {
            K key;
            V value;
            Node(K key,V value)
            {
                this.key = key;
                this.value = value;
            }
        }
        
        LinkedList<Node>[] buckets;
        int n;
        int N;

        @SuppressWarnings("unchecked")
        HashMap()
        {
            N = 4;
            this.buckets = new LinkedList[N];

            for(int i=0; i<N; i++)
            {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key)
        {
            int bidx = key.hashCode();
            return Math.abs(bidx) % N;
        }

        private int searchInLL(K key,int bidx)
        {
            LinkedList<Node> ll = buckets[bidx];

            for(int i=0; i<ll.size(); i++)
            {
                Node node = ll.get(i);
                if(key==node.key){
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash()
        {
            n =0;
            N *= 2;
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[N];
            for(int i=0; i<N; i++)
            {
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBuckets.length; i++)
            {
                LinkedList<Node> temp = oldBuckets[i];

                for(int j=0; j<temp.size(); j++)
                {
                    Node node = temp.get(j);

                    put(node.key,node.value);
                }
            }
        }
        public void put(K key,V value)
        {
            int bidx = hashFunction(key);
            int didx = searchInLL(key,bidx);
            if(didx!=-1)
            {
                Node node = buckets[bidx].get(didx);
                node.value = value;
            }
            else{
                buckets[bidx].add(new Node(key,value));
                n++;
            }

            double lambda = (double)n/N;

            if(lambda>2.0)
            {
                rehash();
            }
        }

        public boolean containsKey(K key)
        {
            int bidx = hashFunction(key);
            int didx = searchInLL(key,bidx);

            if(didx!=-1) return true;
            return false;
        }

        public V get(K key)
        {
            int bidx = hashFunction(key);
            int didx = searchInLL(key,bidx);

            if(didx!=-1)
            {
                return buckets[bidx].get(didx).value;
            }
            return null;
        }

        public V remove(K key)
        {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);

            if(di!=-1)
            {
                n--;
                return buckets[bi].remove(di).value;
            }
            return null;
        }
        public boolean isEmpty()
        {
            if(n==0) return true;
            return false;
        }

        public ArrayList<K> keySet()
        {
            ArrayList<K> set = new ArrayList<>();

            for(int i=0; i<N; i++)
            {
                LinkedList<Node> temp = buckets[i];
                for(int j=0; j<temp.size(); j++)
                {
                    Node node = temp.get(j);
                    set.add(node.key);
                }
            }
            return set;
        }
    }
    public static void main(String args[])
    {

        HashMap<String,Integer> map = new HashMap<>();

        map.put("India",3);
        map.put("China",18);
        map.put("US",28);
        map.put("UK",4);
        map.put("Rusia",25);

        
        map.remove("China");
        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++)
        {
            System.out.println(keys.get(i)+" = "+ map.get(keys.get(i)));
        }
    }
}
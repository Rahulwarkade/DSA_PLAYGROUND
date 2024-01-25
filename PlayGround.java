import java.util.*;

public class PlayGround
{   
    public static class Heap
    {
        ArrayList<Integer> list = new ArrayList<>();

        private void heapify(int idx)
        {
            int minIdx = idx;
            int leftIdx = (2*minIdx)+1;
            int rightIdx = (2*minIdx)+2;

            if(leftIdx<list.size() && list.get(leftIdx)<list.get(minIdx))
            {
                minIdx = leftIdx;
            }
            if(rightIdx<list.size() && list.get(rightIdx)<list.get(minIdx))
            {
                minIdx = rightIdx;
            }

            if(minIdx!=idx)
            {
                int temp = list.get(idx);
                list.set(idx,list.get(minIdx));
                list.set(minIdx,temp);
                heapify(minIdx);
            }
        }

        boolean isEmpty()
        {
            if(list.size()>0) return false;
            return true;
        }
        void add(int value)
        {
            list.add(value);

            int x = list.size()-1;
            int y = (x-1)/2;

            while(list.get(y)>list.get(x))
            {
                int temp = list.get(y);
                list.set(y,list.get(x));
                list.set(x,temp);
                
                x = y;
                y = (x-1)/2;
            }
        }

        int peek()
        {
            if(isEmpty()) return -1;
            return list.get(0);
        }

        int remove()
        {
            if(isEmpty()) return -1;
            int value = list.get(0);
            
            int li = list.size()-1;
            list.set(0,list.get(li));
            list.set(li,value);

            list.remove(li);

            heapify(0);
            return value;
        }
    }

    public static void heapify(int[] arr,int idx,int size)
    {
        int maxIdx = idx;
        int leftIdx = (2*idx)+1;
        int rightIdx = (2*idx)+2;

        if(leftIdx<size && arr[leftIdx]>arr[maxIdx])
        {
            maxIdx = leftIdx;
        }

        if(rightIdx<size && arr[rightIdx]>arr[maxIdx])
        {
            maxIdx = rightIdx;
        }

        if(maxIdx!=idx)
        {
            int temp = arr[idx];
            arr[idx] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr,maxIdx,size);
        }
    }

    public static void main(String args[])
    {

    }
}
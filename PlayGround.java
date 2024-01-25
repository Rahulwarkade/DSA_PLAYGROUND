import java.util.*;

public class PlayGround
{  
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
    public static void heapSort(int[] arr)
    {
        int n = arr.length;

        for(int i=n/2; i>=0; i--)
        {
            heapify(arr,i,n);
        }

        for(int i=n-1; i>=0; i--)
        {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr,0,i);
        }

    }
    public static void main(String args[])
    {
        int[] arr = {1,2,4,5,3};

        heapSort(arr);

        for(int value : arr)
            System.out.print(value+" ");
    }
}
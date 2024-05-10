import java.util.*;
import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;
public class Java_PlayGround
{


	public static List<Integer> majorityElm(int[] arr, int n)
	{
		HashMap<Integer,Integer> hm = new HashMap<>();
		List<Integer> ans = new ArrayList<>();

		for(int i=0; i<n; i++)
		{
			hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
		}

		for(Integer key : hm.keySet())
		{
			if(hm.get(key)>n/3)
				ans.add(key);
		}

		return ans;
	}
	public static void main(String [] args)
	{
		int n;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		int[] arr = new int[n];

		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();

		

		List<Integer> list = new ArrayList<>();

		list = majorityElm(arr,n);

		for(Integer value : list)
			System.out.println(value);

	}
}
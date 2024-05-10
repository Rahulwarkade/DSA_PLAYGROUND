import java.util.*;
import java.util.Scanner;

public class Java_PlayGround
{


	public static void majorityElm(int[] nums)
	{
		int n = nums.length;
		int cnt1,cnt2,elm1,elm2;
		cnt1 = cnt2=0;
		elm1 =elm2 = Integer.MAX_VALUE;

		for(int i=0; i<n; i++)
		{
			if(cnt1==0 && nums[i]!=elm2)
			{
				cnt1 = 1;
				elm1 = nums[i];
			}
			else if(cnt2==0 && nums[i]!=elm1)
			{
				cnt2 = 1;
				elm2 = nums[i];
			}
			else if(nums[i]==elm1) cnt1++;
			else if(nums[i]==elm2) cnt2++;
			else{
				cnt1--;
				cnt2--;
			}
		}

		List<Integer> ls = new ArrayList<>();
		cnt1 = cnt2 = 0;
		for(int i=0; i<n; i++)
		{
			if(nums[i]==elm1) cnt1++;
			if(nums[i]==elm2) cnt2++;
		}
		int mini = (n/3)+1;

		if(cnt1>=mini) ls.add(elm1);
		if(cnt2>=mini) ls.add(elm2);

		System.out.println(ls);
	}
	public static void main(String [] args)
	{
		int n;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		int[] arr = new int[n];

		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();

		
		majorityElm(arr);

	}
}
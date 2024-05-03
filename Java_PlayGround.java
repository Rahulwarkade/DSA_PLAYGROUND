import java.util.*;

public class Java_PlayGround
{
	public static int[] arr = new int[100];

	public static void main(String [] args)
	{

		int N;
		Scanner jin = new Scanner(System.in);
		N = jin.nextInt();

		arr[0] = 1;
		int len = 1;
		int fact = 1;
		int carry = 0;
		for(int i=1; i<=N; i++)
		{
			int j = 0;
			while(j<len)
			{
				fact = arr[j] * i + carry;
				arr[j] = fact%10;
				carry = fact/10;
				j++;
			}

			while(carry!=0)
			{
				arr[len] = carry%10;
				carry/=10;
				len++;
			}

			for(int k=len-1; k>=0; k--)
			{
				System.out.print(arr[k]);
			}
			System.out.println();
		}
	}
}
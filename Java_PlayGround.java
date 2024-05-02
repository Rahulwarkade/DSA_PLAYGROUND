import java.util.*;

public class Java_PlayGround
{

	public static void pascalTriangle(int n)
	{

		for(int j=1; j<=n; j++)
		{	
			int ans = 1;	
		    System.out.print(ans+" ");
			for(int i=1; i<j; i++)
			{
				ans*= (j-i);
				ans/=i;
				System.out.print(ans+" ");
			}
			System.out.println();
		}
	}
	public static void main(String [] args)
	{
		int n;
		Scanner jin = new Scanner(System.in);

		n = jin.nextInt();
		
		pascalTriangle(n);
	}
}
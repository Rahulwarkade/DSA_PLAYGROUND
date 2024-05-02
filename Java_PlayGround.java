import java.util.*;

public class Java_PlayGround
{
	public static int factorial(int n)
	{
		int  fact = 1;

		for(int i=1; i<=n; i++)
			fact*=i;
		return fact;
	}

	public static int nCr(int row, int col)
	{
		int ncr =1;

		for(int i=1; i<=col; i++)
		{
			ncr *= row;
			row--;
			ncr /= i;
		}

		return ncr;

	}

	public static int pascal(int r,int c)
	{
		return nCr(r-1,c-1);
	}
	public static void main(String [] args)
	{
		int r,c;
		Scanner jin = new Scanner(System.in);

		r = jin.nextInt();
		c = jin.nextInt();

		System.out.println("The Pascal value is = "+pascal(r,c));
	}
}
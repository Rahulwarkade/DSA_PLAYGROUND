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
		int  n = factorial(row);
		int  c = factorial(col);
		int  n_minus_c = factorial(row-col);
		int  temp = n_minus_c*c;
		int  ncr = n/temp;
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
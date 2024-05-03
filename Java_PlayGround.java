import java.util.*;
import java.math.BigInteger;
import java.math.BigDecimal;
public class Java_PlayGround
{

	public static BigInteger factorial(int n)
	{
		BigInteger fact = new BigInteger("1");

		for(int i=2; i<=n; i++)
			fact = fact.multiply(BigInteger.valueOf(i));
		return fact;
	}
	public static void main(String [] args)
	{
		
		for(int i=1; i<=24; i++)
		{
			System.out.println(factorial(i));
		}
	}
}
import java.util.*;
import java.math.BigInteger;
import java.math.BigDecimal;
public class Java_PlayGround
{
	public static int[] arr = new int[200];

	public static void main(String [] args)
	{

		BigInteger A = new BigInteger("1999999999222");
		BigInteger B = new BigInteger("10000000002323");


		System.out.println("Addition = "+ A.add(B));
		System.out.println("Subtraction = "+ A.subtract(B));
		System.out.println("Multiplication = "+ A.multiply(B));
		System.out.println("Division = "+ A.divide(B));
		System.out.println("remainder = "+ A.remainder(B));

		BigDecimal X = new BigDecimal("0.03");
		BigDecimal Y = new BigDecimal("0.04");

		System.out.println(Y.subtract(X));
	}
}
package hiho;

import java.util.*;
import java.math.BigInteger;

public class Miller_Rabin_Test {
	public static final int Times = 10;

	public static BigInteger quick_mod(BigInteger a, BigInteger b, BigInteger m) {
		BigInteger ans = BigInteger.ONE;
		a = a.mod(m);
		while (!(b.equals(BigInteger.ZERO))) {
			if ((b.mod(BigInteger.valueOf(2))).equals(BigInteger.ONE)) {
				ans = (ans.multiply(a)).mod(m);
				b = b.subtract(BigInteger.ONE);
			}
			b = b.divide(BigInteger.valueOf(2));
			a = (a.multiply(a)).mod(m);
		}
		return ans;
	}

	public static boolean Miller_Rabin(BigInteger n) {
		if (n.equals(BigInteger.valueOf(2))) //n==2
			return true;
		if (n.equals(BigInteger.ONE))  //n==1
			return false;
		if ((n.mod(BigInteger.valueOf(2))).equals(BigInteger.ZERO))  //n%2 == 0
			return false;
		BigInteger m = n.subtract(BigInteger.ONE); //m = n - 1
		BigInteger y = BigInteger.ZERO; //y = 0
		int k = 0;
		while ((m.mod(BigInteger.valueOf(2))).equals(BigInteger.ZERO)) { //m % 2 = 0
			k++;
			m = m.divide(BigInteger.valueOf(2)); // m = m / 2;
		}
		Random d = new Random();
		for (int i = 0; i < Times; i++) {
			int t = 0;
			if (n.compareTo(BigInteger.valueOf(10000)) == 1) {
				t = 10000;
			} else {
				t = n.intValue() - 1;
			}
			int a = d.nextInt(t) + 1;
			BigInteger x = quick_mod(BigInteger.valueOf(a), m, n);
			for (int j = 0; j < k; j++) {
				y = (x.multiply(x)).mod(n);
				if (y.equals(BigInteger.ONE) && !(x.equals(BigInteger.ONE)) && !(x.equals(n.subtract(BigInteger.ONE))))
					return false;
				x = y;
			}
			if (!(y.equals(BigInteger.ONE)))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		while (sc.hasNextBigInteger()) {
			BigInteger n = sc.nextBigInteger();
			if (Miller_Rabin(n))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}

package List;

public class LastRemaining {
	/*
	 * 递推公式：
	 * 	f(n,m) = 0                      n=1
	 * 	       = [f(n-1,m) + m] % n     n > 1
	 */
	public static int remain(int[] a, int m){
		int n = a.length;
		int idx = 0;
		for(int i=2; i<=n; i++){
			idx = ( idx + m ) / n;
		}
		return a[idx];
	}
	public static void main(String[] args) {
		int[] a = new int[]{0,1,2};
		System.out.println(remain(a,2));

	}

}

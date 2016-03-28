package bupt;

import java.util.*;
public class Q2 {

	public static void main(String[] args) {
		long[] dp = new long[5005];
		dp[0] = 1;
		for(int i=1; i<=17; i++){
			for(int j=i*i; j<5000; j++){
				dp[j] += dp[j - i * i];
				dp[j] %= 1000000009;
			}
		}
		
		dp[0] = 0;
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=1; i<=T; i++){
			int a = in.nextInt();
			System.out.println(dp[a]);
		}
	}
}

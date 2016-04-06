package hiho;

import java.util.Arrays;
import java.util.Scanner;

public class Q1043_WanQuanBeiBao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //商品数
		int M = sc.nextInt(); //重量
		int[] dp = new int[M+1];
		Arrays.fill(dp, 0);
		for(int i=0; i<N; i++){
			int W = sc.nextInt(); //重量
			int V = sc.nextInt(); //价值
			for(int j=W; j<=M; j++){
				dp[j] = Math.max(dp[j], dp[j-W] + V);
			}
		}
		System.out.println(dp[M]);
	}

}

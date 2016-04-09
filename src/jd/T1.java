package jd;

import java.util.Arrays;
import java.util.Scanner;

public class T1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int v = sc.nextInt();
		int[] dp = new int[v+1];
		Arrays.fill(dp, 0);
		String[] fa = new String[v+1];
		fa[0] = "";
		for(int i=0; i<n; i++){
			int a = sc.nextInt();
			int p = sc.nextInt();
			for(int j=v; j>=a; j--){
				if(dp[j] < dp[j-a] + p){
					dp[j] = dp[j-a] + p;
					fa[j] = fa[j-a] + " " + String.valueOf(i+1);
				}
			}
		}
		if(dp[v] == 0){
			System.out.println(0);
			System.out.println("No");
		}else{
			System.out.println(dp[v]);
			System.out.println(fa[v].substring(1));
		}
	}
}

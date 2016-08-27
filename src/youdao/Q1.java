package youdao;

import java.util.Scanner;

public class Q1 {
	public static int nextEmpty(int[] num, int i){
		int n = num.length;
		int count = 0;
		while (count < 2){
			i ++;
			if (num[i%n] == 0) count ++;	
		}
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i ++){
			int n = in.nextInt();
			if (n == 1){
				System.out.println(1);
				continue;
			}
			int[] num = new int[n];
			int k = 1;
			for (int j = 1; k <= n; k ++){
				num[j%n] = k;
				//System.out.println(j%n + " " + k);
				if (k < n)
					j = nextEmpty(num,j);
			}
			for (int j = 0; j < n - 1; j ++) System.out.print(num[j] + " ");
			System.out.println(num[n-1]);
		}
	}

}
package toutiao;

import java.util.*;

public class Q1 {
	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	public static void permute(int[] to, int k) {
		
		for (int i = k + 1; i < to.length; i++) {
			swap(to, i, k);
			permute(to, k + 1);
			swap(to, i, k);
		}
		if (k == to.length - 1) {
			max = Math.max(max, suan(arr, to));
		}
	}
	
	public static long suan(String[] arr, int[] to) {
		long ans = 0;
		long num;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > 1 && to[arr[i].charAt(0) - 'A'] == 0)
				return 0;
			num = 0;
			for (int j = 0; j < arr[i].length(); j++) {
				num = num * 10 + to[arr[i].charAt(j) - 'A'];
			}
			ans += num;
		}
		return ans;
	}

	private static String[] arr;
	private static long max = 0;
	private static Set<Integer> set = new HashSet<Integer>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.next();
			if(arr[i].length()>1){
				set.add(arr[i].charAt(0) - 'A');
			}
		}
		int[] to = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		permute(to, 0);
		System.out.println(max);
	}

}
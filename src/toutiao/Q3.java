package toutiao;
import java.util.Scanner;

public class Q3 {
	public static int ans = 0;
	public static void dfs(String[] str, int i, int k){
		if (i == str.length){
			String s = new String();
			for (int j = 0; j < str.length; j ++){
				s += str[j];
			}
			String temp = s + s;
			int count = 0;
			for (int j = 1; j < temp.length();){
				int re = temp.indexOf(s,j);
				if (re > 0 && re < temp.length()){
					count ++;
					j = re + 1;
				}else{
					break;
				}
			}
			if (count == k){
				ans ++;
			}
			return;
		}
		for (int l = i; l < str.length; l ++){
			String t = str[l];
			str[l] = str[i];
			str[i] = t;
			dfs(str,i+1,k);
			t = str[l];
			str[l] = str[i];
			str[i] = t;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String[] str = new String[n];
		for (int i = 0; i < n; i ++){
			str[i] = in.next();
		}
		dfs(str,0,k);
		System.out.println(ans);
	}

}
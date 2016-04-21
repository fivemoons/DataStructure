package baidu;

import java.util.Scanner;

public class Q1 {
	public static String ans = new String();
	public static int max = Integer.MAX_VALUE;

	public static void dfs(String s, int i, int now, int[] a, int[] b, int left, int right, int value, String cur) {
		// System.out.println(cur+" "+value);
		if (i == s.length()) {
			if ((left == s.length() / 2) && (value < max)) {
				Q1.ans = cur;
				Q1.max = value;
			}
			return;
		}
		if (left > s.length() / 2 || left < right) {
			return;
		}
		while (i < s.length() && s.charAt(i) != '?') {
			cur += s.charAt(i);
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			i++;
		}
		if (i == s.length()) {
			dfs(s, i, now, a, b, left, right, value, cur);
		} else {
			dfs(s, i + 1, now + 1, a, b, left, right + 1, value + b[now], cur + ')');
			dfs(s, i + 1, now + 1, a, b, left + 1, right, value + a[now], cur + '(');
		}
	}

	public static void main(String args[]) {
			Scanner in = new Scanner(System.in);
			while (in.hasNext()) {
				String s = in.next();
				int m = 0;
				for (int i = 0; i < s.length(); i ++){
					if (s.charAt(i) == '?'){
						m ++;
					}
				}
				if (m == 0){
					System.out.println(0);
					System.out.println(s);
				}
				else{
					//System.out.println(s+"   "+m);
					int[] a = new int[m];
					int[] b = new int[m];
					for (int i = 0; i < m; i ++){
						a[i] = in.nextInt();
						b[i] = in.nextInt();
					}
					//System.out.println("a b ");
					if (s.length()%2 == 1){
						System.out.println(-1);
					}else{
						//String ans = new String();
						dfs(s,0,0,a,b,0,0,0,"");
						if (ans.length() == 0){
							System.out.println(-1);
						}else{
							System.out.println(max);
							System.out.println(ans);
						}
					}
				}
			}
	}
}

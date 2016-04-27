package test;

import java.util.*;

public class TestUtils {
	public static int JudgeRegx(String s) throws Exception {
		Stack<Character> stack = new Stack<Character>();
		boolean shuzi = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '0' || c == '1') {
				shuzi = true;
			} else if (c == '(') {
				shuzi = false;
				stack.push(c);
			} else if (c == ')') {
				shuzi = true;
				if (stack.empty()) {
					return 0;
				} else {
					stack.pop();
				}
			} else if (c == '|') {
				if (!shuzi)
					return 0;
				shuzi = false;
			} else if (c == '*') {
				if (!shuzi)
					return 0;
				shuzi = false;
			} else
				return 0;
		}
		if (stack.empty()) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int calcPLength(int[] intAr) throws Exception {
		if (intAr.length <= 1)
			return intAr.length;
		Arrays.sort(intAr);
		int ans = 1;
		int[][] dp = new int[intAr.length][10000005];
		for (int i = 0; i < intAr.length; i++)
			for (int j = 0; j < intAr.length; j++)
				dp[i][j] = 1; // 单独成列

		for (int i = 1; i < intAr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				int diff = intAr[i] - intAr[j];
				dp[i][diff] = dp[j][diff] + 1;
				ans = Math.max(ans, dp[i][diff]);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(JudgeRegx("010101101*"));
		System.out.println(JudgeRegx("(11|0*)*"));
		System.out.println(JudgeRegx(")*111"));
		System.out.println(calcPLength(new int[]{3,8,4,5,6,2}));
	}
}

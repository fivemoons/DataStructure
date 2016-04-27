package test;

public class LCS2 {
	public static int[][] lcs(String s1, String s2){
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int[][] b  = new int[s1.length() + 1][s2.length() + 1];
		for(int i=0; i<=s1.length();i++){
			dp[i][0] = 0;
		}
		for(int j=0; j<s2.length(); j++){
			dp[0][j] = 0;
		}
		for(int i=1; i<=s1.length(); i++){
			for(int j=1; j<=s2.length(); j++){
				if(s1.charAt(i-1) ==  s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
					b[i][j] = 0; //左上
				}else if(dp[i-1][j] < dp[i][j-1]){
					dp[i][j] = dp[i][j-1];
					b[i][j] = 1; //左方
				}else{
					dp[i][j] = dp[i-1][j];
					b[i][j] = -1;//上方
				}
			}
		}
		System.out.println(dp[s1.length()][s2.length()]);
		return b;
	}
	private static void dfs(int[][] b, String s1, String s2,int x, int y){
		if(b[x][y] == 0){
			if(x-1>=0 && y-1>=0){
				dfs(b,s1,s2,x-1,y-1);
				System.out.print(s1.charAt(x-1));
			}
		}else if (b[x][y] == -1){
			if (x-1>=0) dfs(b,s1,s2,x-1,y);
		}else{
			if (y-1>=0) dfs(b,s1,s2,x,y-1);
		}
	}
	public static void main(String[] args) {
		String s1 = "ABCBDAB";
		String s2 = "BDCABA";
		dfs(lcs(s1,s2),s1,s2,s1.length(),s2.length());
	}
}

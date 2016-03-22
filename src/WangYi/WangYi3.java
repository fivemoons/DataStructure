package WangYi;

import java.util.Scanner;

public class WangYi3 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int k = scanner.nextInt();
			int[][] mogu = new int[n+1][m+1];
			for(int i=0; i<k; i++){
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				mogu[x][y]++;
			}
			for(int i=1; i<=n; i++){
				for(int j=1; j<=m; j++){
					mogu[i][j] += mogu[i-1][j] + mogu[i][j-1] - mogu[i-1][j-1];
				}
			}
			if(n<=3 && m<=3)
				System.out.println(mogu[n][m]);
			else{
				int ans = 0;
				for(int i0=3; i0<=n; i0++){
					for(int i1=3; i1<=n; i1++){
						for(int j0=3; j0<=m; j0++){
							for(int j1=3; j1<=m; j1++){
								int ans1 = mogu[i0][j0] - mogu[i0-3][j0] - mogu[i0][j0-3] + mogu[i0-3][j0-3];
								int ans2 = mogu[i1][j1] - mogu[i1-3][j1] - mogu[i1][j1-3] + mogu[i1-3][j1-3];
								int maxi = Math.max(i0, i1);
								int mini = Math.min(Math.min(i0, i1) + 3 , n);
								int maxj = Math.max(j0, j1);
								int minj = Math.min(Math.min(j0, j1) + 3 , m);
								int ans3 = mogu[mini][minj] - mogu[maxi-1][minj] - mogu[mini][maxj-1] + mogu[maxi-1][maxj-1];
								if(ans3<0) ans3=0;
								ans = Math.max(ans, ans1 + ans2 - ans3);
							}
						}
					}
				}
				System.out.println(ans);
			}
		}
	}
}

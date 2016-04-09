package microsoft;

import java.util.Scanner;

public class Q3 {
	private static final int MM = 1000000000;
	private static boolean B(char[][] map, int x, int y){
		if(x < map.length && y<map[0].length && map[x][y] == '.')
			return false;
		else
			return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		if(N == 0 || M == 0){
			System.out.println(0);
			return;
		}
		char[][] map = new char[N][M];
		for(int i=0; i<N; i++){
			map[i] = sc.nextLine().toCharArray();
		}

		int[][] hengzhe = new int[N][M];
		int[][] shuzhe = new int[N][M];
		
		hengzhe[0][0] = (B(map,0,0) ? 1 : 0);
		shuzhe[0][0] = MM;
		for(int j=1; j<M; j++){
			hengzhe[0][j] = hengzhe[0][j-1] + (B(map,0,j) ? 1 : 0);
			shuzhe[0][j] = MM;
		}
		if(1<N) shuzhe[1][0] = (B(map,0,1) ? 0 : 1);
		hengzhe[1][0] = MM;
		for(int i=2; i<N; i++){
			shuzhe[i][0] = shuzhe[i-1][0] + (B(map,i,0) ? 1 : 0);
			hengzhe[i][0] = MM;
		}
		
		for(int i=1; i<N; i++){
			for(int j=1; j<M; j++){
				shuzhe[i][j] = Math.min(shuzhe[i-1][j],hengzhe[i-1][j] + (B(map,i-1,j+1) ? 0 : 1) )
						+ (B(map,i,j) ? 1 : 0);
				hengzhe[i][j] = Math.min(hengzhe[i][j-1],shuzhe[i][j-1] + (B(map,i+1,j-1) ? 0 : 1) )
						+ (B(map,i,j) ? 1 : 0);
			}
		}
		System.out.println(Math.min(hengzhe[N-1][M-1], shuzhe[N-1][M-1]));
	}
}

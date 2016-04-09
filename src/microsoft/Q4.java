package microsoft;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int kk=0; kk<T; kk++){
			int N = sc.nextInt();
			int[][] in = new int[N][3];
			int maxx = 0;
			int maxy = 0;
			int maxz = 0;
			
			for(int i=0; i<N; i++){
				in[i][0] = sc.nextInt() - 1;
				in[i][1] = sc.nextInt() - 1;
				in[i][2] = sc.nextInt() - 1;
				maxx = Math.max(maxx, in[i][0]);
				maxy = Math.max(maxy, in[i][1]);
				maxz = Math.max(maxz, in[i][2]);
			}
			
			boolean[][][] map = new boolean[maxx][maxy][maxz];
			for(int i=0; i<maxx; i++){
				for(int j=0; j<maxy; j++){
					for(int k=0; k<maxz; k++){
						map[i][j][k] = false;
					}
				}
			}
			for(int i=0; i<N; i++){
				map[ in[i][0] ][ in[i][1] ][ in[i][2] ] = true;
			}
			
		}
	}
}

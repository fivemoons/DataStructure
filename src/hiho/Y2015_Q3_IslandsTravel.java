package hiho;

import java.util.*;

public class Y2015_Q3_IslandsTravel {
	private static int len(int[][] map, int x, int y){
		return Math.min(
				Math.abs(map[x][0]-map[y][0]), 
				Math.abs(map[x][1]-map[y][1]));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][2];
		for(int i=0; i<N; i++){
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();		
		}
		int[][] len = new int[N][N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				len[i][j] = 1000000000;
			}
		}
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				len[i][j] = Math.min(len[i][j], len(map,i,j));
			}
		}
		for(int k=0; k<N; k++){
			for(int i=0; i<N; i++){
				if(i!=k)
				for(int j=0; j<N; j++){
					if((j!=i) && (j!=k)){
						len[i][j] = Math.min(len[i][j], 
								len(map,i,k) + len(map,k,j)
								);
					}
				}
			}
		}
		System.out.println(len[0][N-1]);
	}
	
}

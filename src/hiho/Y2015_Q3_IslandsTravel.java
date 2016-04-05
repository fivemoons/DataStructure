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

		boolean[] inqueue = new boolean[N];
		Arrays.fill(inqueue, false);
		int[] ans = new int[N];
		Arrays.fill(ans, 1000000000);
		
		Queue<Integer> q = new PriorityQueue<Integer>(N);
		
		q.offer(0);
		inqueue[0] = true;
		ans[0] = 0;
		while(!q.isEmpty()){
			int cur = q.poll();
			inqueue[cur] = false;
			for(int i=0; i<N; i++){
				int temp = ans[cur] + len[cur][i];
				if(ans[i] > temp){
					ans[i] = temp;
					if(!inqueue[i]){
						q.offer(i);
						inqueue[i] = false;
					}
				}
			}
		}
		
		System.out.println(ans[N-1]);
	}
	
}

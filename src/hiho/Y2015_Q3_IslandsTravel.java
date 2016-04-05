package hiho;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Y2015_Q3_IslandsTravel {
	private static int len(point[] map, int x, int y){
		int a = Math.abs(map[x].x-map[y].x);
		int b = Math.abs(map[x].y-map[y].y);
		return a < b ? a : b;
	}
	private static class point{
		int x;
		int y;
		int[] list= new int[6];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		point[] map = new point[N];
		for(int i=0; i<N; i++){
			map[i] = new point();
		}
		TreeMap<Integer,Integer> mapx = new TreeMap<Integer,Integer>(); //dian xiaibao
		TreeMap<Integer,Integer> mapy = new TreeMap<Integer,Integer>();
		
		for(int i=0; i<N; i++){
			map[i].x = sc.nextInt();
			map[i].y = sc.nextInt();
			mapx.put(map[i].x, i);
			mapy.put(map[i].y, i);
		}
		
		for(int i=0; i<N; i++){
			int x = map[i].x;
			int y = map[i].y;
			
			map[i].list[0] = mapx.get(x);
			map[i].list[1] = mapy.get(y);
			map[i].list[2] = mapx.lowerKey(map[i].x) == null ? -1 : mapx.get( mapx.lowerKey(map[i].x) );
			map[i].list[3] = mapx.higherKey(map[i].x) == null ? -1 : mapx.get( mapx.higherKey(map[i].x) );
			map[i].list[4] = mapy.lowerKey(map[i].y) == null ? -1 : mapy.get( mapy.lowerKey(map[i].y) );
			map[i].list[5] = mapy.higherKey(map[i].y) == null ? -1 : mapy.get( mapy.higherKey(map[i].y) );
		}

		boolean[] inqueue = new boolean[N];
		Arrays.fill(inqueue, false);
		int[] ans = new int[N];
		Arrays.fill(ans, 1000000000);
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(0);
		inqueue[0] = true;
		ans[0] = 0;
		while(!q.isEmpty()){
			int cur = q.poll();
			inqueue[cur] = false;
			for(int i=0; i<6; i++){
				int idx = map[cur].list[i];
				if(idx == -1) continue;
				int temp = ans[cur] + len(map,cur,idx);
				if(ans[ idx ] > temp){
					ans[idx] = temp;
					if(!inqueue[idx]){
						q.offer(idx);
						inqueue[idx] = false;
					}
				}
			}
		}
		
		System.out.println(ans[N-1]);
	}
	
}

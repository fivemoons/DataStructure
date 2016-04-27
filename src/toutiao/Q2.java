package toutiao;

import java.util.*;

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		int sum = 0;
		int max = 0;
		int cur = 0;
		for(int ii = 0; ii<n; ii++){
			int l1 = sc.nextInt();
			int l2 = sc.nextInt();
			if(l1 == 1){
				cur++;
				sum += l2;
				if(map.containsKey(l2)){
					map.put(l2, map.get(l2) + 1);
				}else{
					map.put(l2, 1);
				}
			}else if (l1 == 2){
				cur--;
				sum -= l2;
				if(map.get(l2) == 1){
					map.remove(l2);
				}else{
					map.put(l2, map.get(l2) - 1);
				}
			}
			max = map.lastKey();
			if(cur >=3 && sum > 2 * max){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
}

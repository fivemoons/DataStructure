package bupt;

import java.util.*;

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean[] set = new boolean[100005];
		int[] ss = new int[210000];
		
		for(int i=0; i<T; i++){
			Arrays.fill(set, false);
			int l = 0;
	    		int ans = 0;
	    		
			int N = sc.nextInt();
		    	for(int j=0; j<(2*N); j++){
		    		if(j<N){
		    			ss[j] = sc.nextInt();
		    			ss[j+N] = ss[j];
		    		}
		    		if (set[ss[j]]){
		    			while(ss[l] != ss[j]){
		    				set[ss[l]] = false;
		    				l++;
		    			}
		    			l++;
		    			if(l>N) break;
		    		}else{
		    			set[ss[j]] = true;
		    			ans = (ans > j-l+1) ? ans : (j-l+1);
		    		}
		    	}
		    System.out.println(ans);
		}
	}
}

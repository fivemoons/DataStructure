package bupt;
import java.util.*;

public class Q1 {
	public static void main(String[] args) {
		int max = (1<<15);
		boolean[] pr = new boolean[1<<15+1];
		Arrays.fill(pr, true);
		pr[0] = false;
		pr[1] = false;
		for(int i=2; i<=max; i++){
			if(pr[i]){
				for(int j=2; i*j<=max; j++){
					pr[i*j] = false;
				}
			}
		}
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			if (num == 0) break;
			int count = 0;
			for(int i=2; i+i<=num; i++){
				if(pr[i] && pr[num-i])
					count++;
			}
			System.out.println(count);
		}
	}
}
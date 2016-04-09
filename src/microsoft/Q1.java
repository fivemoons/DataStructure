package microsoft;
import java.util.*;

public class Q1 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int TASKS = in.nextInt();
			for (int t = 0; t < TASKS; t++) {
				int N = in.nextInt();
				int P = in.nextInt();
				int W = in.nextInt();
				int H = in.nextInt();
				int[] num = new int[N];
				for (int i = 0; i < N; i++)
					num[i] = in.nextInt();
				int max = 1;
				for (int size = 2; size <= Math.min(W, H); size++) {
					int col = W/size;
					int row = H/size;
					int total = 0;
					for (int i = 0; i < N; i++) {
						total += (int) Math.ceil((double) num[i] / (double) col);
					}
					
					if (P * row >= total)
						max = size;
				}
				System.out.println(max);
			}
		}
	}
}
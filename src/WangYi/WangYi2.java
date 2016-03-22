package WangYi;

import java.util.Scanner;

public class WangYi2 {
	public static boolean can(int R,int x1,int y1,int x0,int y0){
		return Math.sqrt(((x1-x0)*(x1-x0)+(y1-y0)*(y1-y0))) <= R;
	}
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int R = scanner.nextInt();
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			int x3 = scanner.nextInt();
			int y3 = scanner.nextInt();
			int x0 = scanner.nextInt();
			int y0 = scanner.nextInt();
			int ans = 0;
			if(can(R,x1,y1,x0,y0)) ans++;
			if(can(R,x2,y2,x0,y0)) ans++;
			if(can(R,x3,y3,x0,y0)) ans++;
			System.out.println(ans+"x");
		}
	}
}

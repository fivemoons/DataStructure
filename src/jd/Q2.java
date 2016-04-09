package jd;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int d = sc.nextInt();
			int sumTime = sc.nextInt();
			int[][] in = new int[d][2];
			int max = 0;
			int min = 0;
			for(int i=0; i<d; i++){
				in[i][0] = sc.nextInt();
				min += in[i][0];
				in[i][1] = sc.nextInt();
				max += in[i][1];
			}
			if(sumTime > max || sumTime < min){
				System.out.println("No");
			}else{
				System.out.println("Yes");
				int duo = sumTime - min;
				if(in[0][1] - in[0][0] <= duo){
					System.out.print(in[0][1]);
					duo -= (in[0][1] - in[0][0]);
				}else{
					System.out.print(in[0][0] + duo);
					duo = 0;
				}
				for(int i=1; i<d; i++){
					if(in[i][1] - in[i][0] <= duo){
						System.out.print(" "+in[i][1]);
						duo -= (in[i][1] - in[i][0]);
					}else{
						System.out.print(" "+ (in[i][0] + duo));
						duo = 0;
					}
				}
				System.out.println();
			}
		}
	}
}

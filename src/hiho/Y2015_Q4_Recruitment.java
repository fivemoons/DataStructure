package hiho;

import java.util.Scanner;

public class Y2015_Q4_Recruitment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //总人数
		int X = sc.nextInt(); //男人数
		int Y = sc.nextInt(); //女人数
		int B = sc.nextInt(); //总工资
		int[][] minput = new int[N+1][3]; //N个男人的输入 价值 工资
		int[][] winput = new int[N+1][3]; //N个女人的输入 价值 工资
		int mcount = 0;
		int wcount = 0;
		for(int i=1; i<=N; i++){
			String G = sc.nextLine();
			char gg = G.charAt(0);
			G = G.substring(2);
			String[] sarr = G.split(" ");
			if(gg=='M'){
				mcount++;
				minput[mcount][0] = i;
				minput[mcount][1] = Integer.parseInt(sarr[0]);
				minput[mcount][2] = Integer.parseInt(sarr[1]);
			}else if(gg=='F'){
				wcount++;
				winput[wcount][0] = i;
				winput[wcount][1] = Integer.parseInt(sarr[0]);
				winput[wcount][2] = Integer.parseInt(sarr[1]);
			}
		}
		
		int[][] men = new int[X+1][B+1];  //N个男人 B工资能多少能力
		int[][] women = new int[Y+1][B+1]; //N个女人 B工资能多少能力
		int[][][] mset = new int[X+1][B+1][X+1];
		int[][][] wset = new int[Y+1][B+1][Y+1];
		
		for(int j=1; j<=mcount; j++){ //枚举每一个人
			for(int i=j; i>=1; i--){ //现在选多少人
				int V = minput[j][1];
				int S = minput[j][2];
				for(int k=V; k<=B; k++){ //工资
					int temp = men[i-1][k-V] + S; //要了这个人
					if (temp > men[i][k]){ //只有严格小于才要这个人
						men[i][k] = temp;
						mset[i][k] = mset[i-1][k-V].clone();
						mset[i][k] [ ++mset[i][k][0] ] = minput[j][0];
					}
				}
			}
		}
	}

}

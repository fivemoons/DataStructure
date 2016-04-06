package hiho;

import java.util.Scanner;

public class Y2015_Q4_Recruitment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //总人数
		int X = sc.nextInt(); //男人数
		int Y = sc.nextInt(); //女人数
		int B = sc.nextInt(); //总工资
		sc.nextLine();
		int[][] mdp = new int[N+1][B+1]; //男dp
		int[][] wdp = new int[N+1][B+1]; //女dp
		long[][][] mrec = new long[N+1][B+1][2];
		long[][][] wrec = new long[N+1][B+1][2];
		for(int i=0; i<=N; i++){
			for(int j=0; j<=B; j++){
				mdp[i][j] = wdp[i][j] = -1; //初始值赋值-1
			}
		}
		
		int mcount = 0;
		int wcount = 0;
		int sum = 0;
		wdp[0][0] = mdp[0][0] = 0; //起点0
		
		for(int i=1; i<=N; i++){
			String G = sc.nextLine();
			char gg = G.charAt(0);
			String[] sarr = G.split(" ");
			int V = Integer.parseInt(sarr[1]);
			int S = Integer.parseInt(sarr[2]);
			sum += S;
			sum = Math.min(sum, B); //判断当前最大的工资
			if(gg=='M'){
				if(mcount != X) mcount++;
				for(int j= mcount; j >= 1; j--){
					for(int k = sum; k >= S; k--){
						if(mdp[j - 1][k - S] >= 0 && mdp[j][k] < mdp[j - 1][k - S] + V){
							mdp[j][k] = mdp[j - 1][k - S] + V;
							mrec[j][k][0] = mrec[j - 1][k - S][0]; //使用了100位的位图来记录方案数
							mrec[j][k][1] = mrec[j - 1][k - S][1];
							if(i - 1 < 50)
								mrec[j][k][0] |= 1L << (i - 1);
							else
								mrec[j][k][1] |= 1L << (i - 1 - 50);
						} 
					}
				}
			}else{
				if(wcount != Y) wcount++;
				for(int j = wcount; j >= 1; j--){
					for(int k = sum; k >= S; k--){
						if(wdp[j - 1][k - S] >= 0 && wdp[j][k] < wdp[j - 1][k - S] + V){
							wdp[j][k] = wdp[j - 1][k - S] + V;
							wrec[j][k][0] = wrec[j - 1][k - S][0];
							wrec[j][k][1] = wrec[j - 1][k - S][1];
							if(i - 1 < 50)
								wrec[j][k][0] |= 1L << (i - 1);
							else
								wrec[j][k][1] |= 1L << (i - 1 - 50);
						} 
					}
				}
			}
		}
		
		//组合
		int ans = -1, count = 0; //ans是总价值 count是总工资
		long record[] = new long[2];
		for(int i = 0; i <= B; i++){
			if(mdp[X][i] < 0) continue;
			for(int j = 0; j <= B - i; j++){
				if(wdp[Y][j] < 0) continue;
				if( ans < mdp[X][i] + wdp[Y][j] || ans == mdp[X][i] + wdp[Y][j] && count > i + j){ //喜欢更大的价值 或者相同价值 更小的工资
					ans = mdp[X][i] + wdp[Y][j];
					count = i + j;
					record[0] = mrec[X][i][0] | wrec[Y][j][0];
					record[1] = mrec[X][i][1] | wrec[Y][j][1];
				}
				else if(mdp[X][i] + wdp[Y][j] == ans && count == i + j) //相同的价值  相同的工资
				{
					long record0 = mrec[X][i][0] | wrec[Y][j][0];
					long record1 = mrec[X][i][1] | wrec[Y][j][1];
					if(record0 < record[0] || record0 == record[0] && record1 < record[1]) //选择字典序小的方案
					{
						record[0] = record0;
						record[1] = record1;
					}
				}
			}	
		} 
		
		System.out.println(ans + " " + count);
		
		for(int i = 1; i <= 50; i++){
			if((record[0] & 1) == 1)
				System.out.print(i+" ");
			record[0] >>= 1;
		}
		
		for(int i = 51; i <= 100; i++){
			if((record[1] & 1) == 1)
				System.out.print(i+" ");
			record[1] >>= 1;
		}
		System.out.println();
	}
}
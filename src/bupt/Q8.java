package bupt;

import java.util.Scanner;

public class Q8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int xA = 0;
		int xB = 0;
		for(int i=1; i<=T; i++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			sc.nextLine();
			char[][] map = new char[n][m];
			for(int j=0; j<n; j++){
				map[j] = sc.nextLine().toCharArray();
				for(int kk=0; kk<m; kk++){
					if(map[j][kk] == 'x'){
						xA = j;
						xB = kk;
					}
				}
			}
			int ans = 0;
			for(int yix=0; yix<=xA; yix++){
				for(int yiy=0; yiy<=xB; yiy++){
					for(int erx=xA; erx<n; erx++){
						for(int ery=xB; ery<m; ery++){
							boolean flag = true;
							for(int ii=yix; ii<=erx; ii++){
								for(int jj=yiy; jj<=ery; jj++){
									if(map[ii][jj] == 'y'){
										flag = false;
										break;
									}
								}
								if(!flag) break;
							}
							if(flag) ans = Math.max(ans, (erx-yix+1)*(ery-yiy+1));
						}
					}
				}
			}
			System.out.println("Case #"+i+": "+ans);
		}
	}
}

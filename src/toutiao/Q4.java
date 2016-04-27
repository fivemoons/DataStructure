package toutiao;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        long k = in.nextLong();
        int[] xx = new int[64];
        int[] kk = new int[64];
        int[] yy = new int[64];
        for(int i=0; i<64; i++){
        	if(((x >> i) & 0x01) != 0)
        		xx[i] = 1;
        	if(((k >> i) & 0x01) != 0)
        		kk[i] = 1;
        }
        int j = 0;
        for(int i=0; i<64; i++){
        	if (xx[i] == 0)
        		yy[i] = kk[j++];
        }
        long ans = 0;
        for(int i=63; i>=0; i--){
        	ans = ((ans << 1) | yy[i]);
        }
        System.out.println(ans);
    }
}

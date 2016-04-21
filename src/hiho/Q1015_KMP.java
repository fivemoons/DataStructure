package hiho;

import java.util.Scanner;

public class Q1015_KMP {
	private static int[] getNext(String p){
		//-1 0 0 0 0 0
		int N = p.length();
		
		int[] next = new int[N];
		next[0] = -1;
		
		for(int j=1,k=-1; j<N;j++){
			while(k!=-1 && p.charAt(j-1) != p.charAt(k)){
				k = next[k];
			}
			k++;
			next[j] = k;
		}
		return next;
		
	}
	private static int KMP(String s, String p){
		if ("".equals(s)) return 0;
		int[] next = getNext(s);
		int i = 0;
		int j = 0;
		while ((i<p.length())&&(j < s.length())){
			if ((j == -1)||(p.charAt(i) == s.charAt(j))){//如果已经无路可退或者匹配上了
				i++;
				j++;
			}
			else{
				j = next[j]; //j往后退一个
			}
		}
		if (j == p.length())
			return i - j;
		else
			return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<N; i++){
			String s = sc.nextLine();
			String p = sc.nextLine();
			System.out.println(KMP(s,p));
		}
	}

}

package _360;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			StringBuffer sb = new StringBuffer(sc.next());
			int count = 0;
			for(int i=1; i<sb.length(); i++){
				if(sb.charAt(i) == '.' && sb.charAt(i-1) == '.'){
					count++;
				}
			}
			for(int k=0; k<m; k++){
				int idx = sc.nextInt();
				idx--;
				char c = sc.next().trim().charAt(0);
				char lastc = sb.charAt(idx);
				sb.deleteCharAt(idx);
				sb.insert(idx, c);
				if(lastc != '.' && c != '.'){
				}else if(lastc == '.' && c == '.'){
				}else if(lastc == '.' && c != '.'){ //. ->b
					if((idx-1 >= 0) && sb.charAt(idx-1) == '.'){
						count--;
					}
					if((idx+1<sb.length()) && sb.charAt(idx+1)=='.'){
						count--;
					}
				}else if(lastc != '.' && c == '.'){ // b->.
					if((idx-1 >= 0) && sb.charAt(idx-1) == '.'){
						count++;
					}
					if((idx+1<sb.length()) && sb.charAt(idx+1)=='.'){
						count++;
					}
				}
				System.out.println(count);
			}
		}
	}
}

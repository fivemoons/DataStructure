package baidu;
import java.util.*;

public class Q2 {
	public static boolean isluck(String a, String b){
		for(int i=0; i<b.length(); i++){
			char c = b.charAt(i);
			int k = a.indexOf(c);
			if(k == -1) return false;
			a = a.substring(k+1);
		}
		return true;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int a = in.nextInt();
			int b = in.nextInt();
			if (a < b){
				System.out.println(b);
			}
			else{
				int ans = a+1;
				while( !isluck(Integer.toString(ans),Integer.toString(b)) )
						ans++;
				System.out.println(ans);
			}
		}
	}
}
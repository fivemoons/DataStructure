package microsoft;
import java.util.*;

class R{
	boolean isYes;
	int p;
	int mask;
}

public class Q2 {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int M = in.nextInt();
			String[] type = new String[10];
			String[] address = new String[20];
			R nowR;
			ArrayList<R> rList = new ArrayList<R>();
			for (int i = 0; i < N; i ++){
				String str = in.nextLine();
				boolean Yes = str.split(" ")[0].equals("allow");
				
				str = str.split(" ")[1];
				
				int pos = str.indexOf('/');
				
				String ip;
				int mask;
				
				if (pos > 0){
					ip = str.substring(0,pos);
					mask = Integer.parseInt(str.substring(pos+1));
				}
				else{
					ip = str;
					mask = 32;
				}
				
				String[] ips = str.split(".");
				long ips = Integer.parseInt(ips[0]) + Integer.parseInt(ips[1]) + Integer.parseInt(s)
				int 
			}
		}
	}
}
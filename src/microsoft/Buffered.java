package microsoft;

import java.io.*;
import java.util.*;
public class Buffered {
	private  static int[] sp(String s,String sp){
		String[] sarr = s.trim().split(sp);
		int[] ans = new int[sarr.length];
		for(int i=0; i<sarr.length; i++){
			ans[i] = Integer.parseInt(sarr[i]);
		}
		return ans;
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) { //抛出异常
			e.printStackTrace();
		}
	}

}


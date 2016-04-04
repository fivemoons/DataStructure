package hiho;
import java.io.*;
import java.util.*;
public class Y2015_Q2_ProfessorQsSoftware {
	private  static int[] sp(String s,String sp){
		String[] sarr = s.trim().split(sp);
		int[] ans = new int[sarr.length];
		for(int i=0; i<sarr.length; i++){
			ans[i] = Integer.parseInt(sarr[i]);
		}
		return ans;
	}
	private static Map<Integer,List<Integer>> cfqbh = new HashMap<Integer,List<Integer>>(100005);
	private static Map<Integer,List<Integer>> cfqjg = new HashMap<Integer,List<Integer>>(100005);
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			int N = 0;
			int M = 0;
			for(int kk = 0; kk<T; kk++){
				int[] temp= sp(br.readLine(), " ");
				N = temp[0]; //多少个转换器
				M = temp[1]; //多少个开始节点
				cfqbh.clear();
				cfqjg.clear();
				
				int[] start = sp(br.readLine(), " ");
				
				for(int i = 0; i<N; i++){
					int[] input = sp(br.readLine(), " ");
					if(!cfqbh.containsKey(input[0])){
						cfqbh.put(input[0], new ArrayList<Integer>());
					}
					cfqbh.get(input[0]).add(i);
					
					if(!cfqjg.containsKey(input[0])){
						cfqjg.put(input[0], new ArrayList<Integer>());
					}
					for(int j = 2; j<input.length; j++){
						cfqjg.get(input[0]).add(input[j]);
					}
				}
				int[] ans = new int[N];
				Queue<Integer> queue = new LinkedList<Integer>();
				for(int i=0; i<start.length; i++){
					queue.add(start[i]);
				}
				while(!queue.isEmpty()){
					int cur = queue.poll();
					if(cfqbh.containsKey(cur)){
						List<Integer> bh = cfqbh.get(cur);
						for(Integer i:bh){
							ans[i] = (ans[i] + 1) % 142857;
						}
						List<Integer> jg = cfqjg.get(cur);
						for(Integer i:jg){
							queue.add(i); 
						}
					}
				}
				
				if(N>0)
					System.out.print(ans[0]);
				for(int i=1; i<N; i++){
					System.out.print(" "+ans[i]);
				}
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}


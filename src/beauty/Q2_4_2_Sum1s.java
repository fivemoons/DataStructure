package beauty;

public class Q2_4_2_Sum1s {
	public static int sum(int n){
		int ans = 0;
        for(long m = 1; m <=n; m=m*2){
            long a = n / m;
            long x = a % 2;
            a = a / 2;
            long b = n % m;
            if(x == 0){
                ans += a * m;
            }else{
                ans += a * m + b + 1;
            }
        }
        return ans;
	}
	public static void main(String[] args) {
		System.out.println(sum(6));
	}
}

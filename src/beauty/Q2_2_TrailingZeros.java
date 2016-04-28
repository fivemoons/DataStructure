package beauty;

public class Q2_2_TrailingZeros {
    public long trailingZeros(long n) {
        long ans = 0;
        while (n != 0){
            n = n / 5;
            ans += n;
        }
        return ans;
    }
	public static void main(String[] args) {
	}

}

package array;

public class Fibonacci {
	public static int Fibonaccin(int n){
		int[] arr = new int[n+1];
		arr[0] = 0;
		if(n>=1) arr[1] = 1;
		if(n>=2) arr[2] = 1;
		for(int i=3; i<=n; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}
	public static void main(String[] args) {
		System.out.println(Fibonaccin(4));

	}

}

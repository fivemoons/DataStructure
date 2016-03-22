package WangYi;
import java.util.Scanner;

public class WangYi1 {
	public static int gcd(int a, int b){
		if(a < b) return gcd(b,a);
		if(a % b ==0){
			return b;
		}else{
			return gcd(b,a % b);
		}
	}
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
			int a = input.nextInt();
			for(int i=0; i<n; i++){
				int temp = input.nextInt();
				if(temp<=a){
					a += temp;
				}else{
					a += gcd(temp,a);
				}
			}
            System.out.println(a);
        }
	}

}


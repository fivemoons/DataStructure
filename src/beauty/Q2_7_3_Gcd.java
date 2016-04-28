package beauty;

public class Q2_7_3_Gcd {
	public static int gcd(int x,int y){
		if(x < y){
			return gcd(x,y);
		}else if(y == 0){
			return x;
		}else{
			return gcd(y,x%y);
		}
	}
	public static int gcd2(int x,int y){
		if(x < y)
			return gcd(y,x);
		if(y == 0)
			return x;
		if( (x & 1) == 1 && (y & 1) == 1){
			return gcd(y,x-y);
		}else if ( (x&1)==1 && (y&1) == 0 ){
			return gcd(x,y>>1);
		}else if ( (x&1)==0 && (y&1) == 1){
			return gcd(x>>1,y);
		}else
			return gcd(x>>1,y>>1)<<1;
	}
	public static void main(String[] args) {
		System.out.println(gcd(42,30));
	}

}

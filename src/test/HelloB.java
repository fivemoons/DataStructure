package test;



public class HelloB extends HelloA{
	public HelloB(){
		System.out.println("HelloB");
	}
	{System.out.println("i am B class");}
	static {System.out.println("static B");}
	public static void main(String[] args) {
		new HelloB();
		int ans = 0;
		for(int i=888; i<=1000; i++){
			ans+= i;
		}
		System.out.println(ans);
	}
}
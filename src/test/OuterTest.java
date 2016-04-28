package test;

public class OuterTest {
	private static int i = 1;
	private int j = 10;
	private int k = 20;
	
	public static void outer_f1(){}
	public void outer_f2(){}
	
	//成员内部类中，不能定义静态成员
	//成员内部类中，可以访问外部类的所有成员
	class Inner{
		//static int inner_i = 100;//内部类中不允许定义静态变量
		int j = 100; //内部类和外部类的实例变量可以共存
		int inner_i = 1;
		void inner_f1(){
			System.out.println(i); //在内部类中访问内部类自己的变量直接用变量名
			System.out.println(j); //在内部类中访问内部类自己的变量也可以用this.变量名
			System.out.println(this.j);
			System.out.println(OuterTest.this.j); //在内部类中访问外部类中与内部类同名的实例变量用外部类名.this.变量名。
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

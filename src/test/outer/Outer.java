package test.outer;
/*
 * 内部类测试
 * 1、成员内部类
 * 2、局部内部类
 * 3、静态内部类
 * 4、匿名内部类
 * 目的：操作外围类，实现多重继承
 * 编译后：Outer.class Outer$inner.class
 */
public class Outer {
	private static int i = 1;
	private int j = 10;
	private int k = 20;
	public static void outer_f1(){}
	public void outer_f2(){}
	//成员内部类中，不能定义静态成员
	//成员内部类中，可以访问外部类的所有成员
	class Inner{
		//static int inner_i = 100; //内部类中不允许定义静态变量
		int j = 100; //内部类和外部类的实例变量可以共存
		int inner_i = 1;
		void inner_f1(){
			System.out.println(i);
			System.out.println(j);//在内部类中访问内部类自己的变量直接用变量名
			System.out.println(this.j);//在内部类中访问内部类自己的变量也可以用this.变量名
			System.out.println(Outer.this.j);//在内部类中访问外部类中与内部类同名的实例变量用外部类名.this.变量名
			System.out.println(k);//如果内部类中没有与外部类同名的变量，则可以直接用变量名访问外部类变量
			outer_f1();
			outer_f2();
		}
	}
	//外部类的非静态方法访问成员内部类
	public void outer_f3(){
		Inner inner = new Inner();
		inner.inner_f1();
	}
	//外部类的静态方法访问成员内部类，与在外部类外部访问成员内部类一样
	public static void outer_f4(){
		Outer out = new Outer(); //step1 建立外部类对象
		Inner inner = out.new Inner(); //step2 根据外部类对象建立内部类对象
		inner.inner_f1(); //step3 访问
	}
	public static void main(String[] args) {
		//outer_f4(); //该语句的输出结果和下面三条语句的输出结果一样
		//如果要直接创建内部类的对象，不能想当然地认为只需加上外围类Outer的名字，
		//就可以按照通常的样子生成内部类的对象，而是必须使用此外围类的一个对象来创建其内部类的一个对象。
		//Outer.Inner. outin = out.new Inner();
		//因此，除非你已经有了外围类的一个对象，否则不可能生成内部类的对象，因为此内部类的对象会悄悄地链接到创建它的外围类的对象。
		//如果你用的是静态的内部类，那就不需要对其外围类对象的引用。
		Outer out = new Outer();
		Outer.Inner outin = out.new Inner();
		outin.inner_f1();
	}
	//2
	private int s = 100;
	private int out_i = 1;
	public void f(final int k){
		final int s = 200;
		int i = 1;
		final int j = 10;
		//定义在方法内部
		class Inner2{
			int s = 300; //可以定义与外部类同名的变量
			//static int m = 20; //不可以定义静态变量
			Inner2(int k){
				inner_f(k);
			}
			int inner_i = 100;
			void inner_f(int k){
				//如果内部类没有与外部类同名的变量，在内部类中可以直接访问外部类的实例变量
				System.out.println(out_i);
				//可以访问外部类的局部变量（即方法内的变量），但是变量必须是final的
				System.out.println(j);
				//System.out.println(i);
				//如果内部类中有与外部类同名的变量，直接用变量名访问的是内部类的变量
				System.out.println(s);
				//用this.变量名访问的也是内部类变量
				System.out.println(this.s);
				//用外部类名.this.内部类变量名访问的是外部类变量
				System.out.println(Outer.this.s);
			}
		}
		new Inner2(k);
	}
	public static void main2(String[] args) {
		//访问局部内部类必须先有外部类对象
		Outer out = new Outer();
		out.f(3);
	}
	
	//3
	//静态内部类可以用public protected private 修饰
	//静态内部类中可以定义静态或者非静态的成员
	static class Inner3{
		static int inner_i = 100;
		int inner_j = 200;
		static void inner_f1(){
			//静态内部类只能访问外部类的静态成员(包括静态变量和静态方法)
			System.out.println("Outer.i" + i);
			outer_f1();
		}
		void inner_f2(){
			//静态内部类不能访问外部类的非静态成员(包括非静态变量和非静态方法)
			//System.out.println("Outer.i"+j);
			//outer_f2();
		}
		public void outer_f3(){
			//外部类访问内部类的静态成员：内部类.静态成员
			System.out.println(Inner3.inner_i);
			Inner3.inner_f1();
			//外部类访问内部类的非静态成员：实例化内部类即可
			Inner3 inner = new Inner3();
			inner.inner_f2();
		}
		public static void main(String[] args) {
			new Outer().outer_f3();
		}
	}
	//4 匿名内部类 不能有构造方法 不能定义任何静态成员 方法 类， 不能是 public protected private static 
}

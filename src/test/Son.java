package test;
class Dad{
	private String name = "fa";
	public String getHisName(){
		return name;
	}
}
public class Son extends Dad{
	private String name = "son";
	public static void main(String[] args){
		Son son = new Son();
		System.out.println(son.getHisName());
	}
}

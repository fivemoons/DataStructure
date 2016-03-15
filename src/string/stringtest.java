package string;

public class stringtest {
	public String toString(){
		return "123"+ this;
	}
	public static void main(String[] args) {
		stringtest a = new stringtest();
		System.out.println(a);
	}
}

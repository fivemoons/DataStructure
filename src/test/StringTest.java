package test;

public class StringTest {
	public static String s1 = "123";
	public static void main(String[] args){
		System.out.println(s1.hashCode());
		StringBuffer sb = new StringBuffer();
		sb.append("abc");
		sb.append("de");
		sb.append("fh");
	}
}

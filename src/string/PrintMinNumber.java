package string;

import java.util.Arrays;

class MyString implements Comparable<MyString>{
	String o1;
	public MyString(String o){
		this.o1 = o;
	}
	public int compareTo(MyString o) {
		// TODO 自动生成的方法存根
		String s1 = o1 + o.o1;
		String s2 = o.o1 + o1;
		return (s1.compareTo(s2));
	}
}
public class PrintMinNumber {
    public String PrintMinNumber1(int [] numbers) {
    	if (numbers.length == 0)
    		return null;
    	MyString[] num = new MyString[numbers.length];
    	for (int i = 0; i < numbers.length; i ++){
    		num[i] = new MyString(numbers[i]+"");
    	}
    	Arrays.sort(num);
		return null;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
	}
}

package Tree;

import java.util.ArrayList;
import java.util.List;

public class test1 {
	public static void f(List<Integer> list){
		list = new ArrayList<Integer>();
		list.add(4);
		list.add(5);
		list.add(6);
		return;
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		f(list);
		
		
		for(Integer i:list){
			System.out.println(i);
		}
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
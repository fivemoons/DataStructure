package test;
import java.util.ArrayList;  
import java.util.HashSet;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Set;  
 //这个程序是用来说明List和Set的遍历问题
public class ListAndSetTest {  
  
    public static void main(String[] args) {  
        // List集合的遍历  
        listTest();  
        // Set集合的遍历  
        setTest();  
    }  
  
    private static void setTest() {  
        Set<String> set = new HashSet<String>();  
        set.add("JAVA");  
        set.add("C");  
        set.add("C++");  
        // 重复的加不进去。  
        set.add("JAVA");  
        set.add("JAVASCRIPT");  
  
        //set集合遍历方法1，使用iterator  
        Iterator<String> it = set.iterator();  
        while (it.hasNext()) {  
            String value = it.next();  
            System.out.println(value);  
        }  
          
        //set集合遍历方法2，使用增强for循环。  
        for(String s: set){  
            System.out.println(s);  
        }  
    }  
  
    // 遍历list集合  
    private static void listTest() {  
        List<String> list = new ArrayList<String>();  
        list.add("java111");  
        list.add("java222");  
        list.add("java333");  
        list.add("java444");  
        list.add("java555");  
  
        // 遍历方式1 ，使用iterator  
        Iterator<String> it = list.iterator();  
        while (it.hasNext()) {  
            String value = it.next();  
            System.out.println(value);  
        }  
  
        // 遍历方法2 ， 使用传统for循环进行遍历。  
        for (int i = 0, size = list.size(); i < size; i++) {  
            String value = list.get(i);  
            System.out.println(value);  
        }  
  
        // 遍历方法3 ， 使用增强for循环进行遍历。  
        for (String value : list) {  
            System.out.println(value);  
        }  
    }  
}  

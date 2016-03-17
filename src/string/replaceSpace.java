package string;

public class replaceSpace {
	public static String replace(StringBuffer str){
		for(int i=str.length()-1; i>=0; i--){
			if(str.charAt(i) == ' '){
				str.deleteCharAt(i);
				str.insert(i, new char[]{'%','2','0'});
			}
		}
		return str.toString();
	}
	public static void main(String[] args) {
		System.out.println(replace(new StringBuffer("1234 5678 90")));

	}

}

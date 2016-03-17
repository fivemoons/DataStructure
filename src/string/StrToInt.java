package string;

public class StrToInt {
	public static int stoi(String str){
		if(str == null || str.length() == 0) return 0;
		boolean fs = false;
		if(str.charAt(0) == '-'){
			fs = true;
			str = str.substring(1);
		}else if (str.charAt(0) == '+'){
			fs = false;
			str = str.substring(1);
		}
		int ans = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				ans = ans * 10 + (str.charAt(i)-'0');
			}else{
				return 0;
			}
		}
		if (fs)
			return -ans;
		else
			return ans;
	}
	public static void main(String[] args) {
		System.out.println(stoi("123"));
	}
}

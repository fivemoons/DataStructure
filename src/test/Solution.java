package test;
public class Solution {
    private String Reverse(String s){
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
        return new String(arr);
    }
    public String ReverseSentence(String str) {
        if(str.length() == 0) return str;
        if(str.equals(" ")) return str;
        str = Reverse(str);
        String[] arr = str.split(" ");
        for(int i=0; i<arr.length; i++){
            arr[i] = Reverse(arr[i]);
        }
        String ans = arr[0];
        for(int i=1; i<arr.length; i++){
            ans += " " +  arr[i];
        }
        return ans;
    }
    public static void main(String[] args) {
		Solution s1 = new Solution();
		System.out.println(s1.ReverseSentence(" "));
	}
}
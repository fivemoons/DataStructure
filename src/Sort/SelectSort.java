package Sort;

public class SelectSort {
	public static void Sort(int[] a){
		for (int i = 0; i < a.length-1; i++) { // 数组从0开始
			for(int j=i+1; j<a.length; j++)
			if(a[i] > a[j]){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}
	public static void main(String[] args) {
		int[] a = new int[]{2,3,4,8,6,7,2};
		Sort(a);
		for(int i:a){
			System.out.print(i+" ");
		}
		System.out.println();
	}

}

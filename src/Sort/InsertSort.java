package Sort;

public class InsertSort {
	public static void Sort(int[] a){
		for (int i = 1; i < a.length; i++) { // 数组从0开始
			for(int j=i; j>0 && a[j-1]>a[j]; j--){
				int temp = a[j-1];
				a[j-1] = a[j];
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

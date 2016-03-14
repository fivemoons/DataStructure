package Sort;

public class HeapSort {
	private static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private static void percDown(int[] a, int i, int n){
		int child = 0;
		if (2*i+1<n) child = 2*i+1;
		if((2*i+2<n) && (a[child] < a[child+1])) child++;
		if((child != 0) && (a[i] < a[child])){
			swap(a,i,child);
			percDown(a, child, n);
		}else
			return;
	}
	public static void Sort(int[] a){
		for(int i=a.length/2 - 1; i>=0; i--){
			percDown(a,i,a.length);//建堆 a数组 i开始 堆的长度
		}
		for(int i=a.length-1; i>0; i--){
			swap(a,0,i);
			percDown(a,0,i);
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

package Sort;

public class QuickSort {
	public static void Sort(int[] a, int l, int r){
		int x = a[l + (r - l)/2];
		int i = l;
		int j = r;
		while(i<=j){
			while(a[i] < x) i++;
			while(x < a[j]) j--;
			if(i<=j){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if(l<j) Sort(a, l, j);
		if(i<r) Sort(a, i, r);
	}
	
	public static int select(int[] a, int l, int r, int k){
		
	}
	public static void main(String[] args) {
		int[] a = new int[]{2,3,4,8,6,7,2};
		Sort(a,0,a.length-1);
		for(int i:a){
			System.out.print(i+" ");
		}
		System.out.println();
		
		System.out.println(select(a,0,a.length-1,3));
		
	}
	
}

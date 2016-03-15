package sort;

public class MergeSort {
	private static void merge(int[] a, int[] tmp, int l, int m, int r){
		int ll = l;
		int rr = m + 1;
		int cc = l;
		while((ll <= m) && (rr <= r)){
			if(a[ll] < a[rr]){
				tmp[cc++] = a[ll++]; 
			}else{
				tmp[cc++] = a[rr++];
			}
		}
		while(ll<=m) tmp[cc++] = a[ll++];
		while(rr<=r) tmp[cc++] = a[rr++];
		for(int i=l; i<=r; i++){
			a[i] = tmp[i];
		}
	}
	private static void mergeSort(int[] a, int[] tmp, int l, int r){
		if(l<r){
			int m = (l + (r - l) / 2);
			mergeSort(a, tmp, l,   m);
			mergeSort(a, tmp, m+1, r);
			merge(a, tmp, l, m, r);
		}
	}
	public static void Sort(int[] a){
		int[] tmp = new int[a.length];
		//归并a 存放缓存tmpArray 从0到a.length-1
		mergeSort(a, tmp, 0, a.length-1);
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

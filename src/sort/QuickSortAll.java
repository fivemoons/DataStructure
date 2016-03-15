package sort;

public class QuickSortAll {
	/*
	 * 快排，递归，选择第一个元素当做指针
	 */
	public static void quickSort0(int[] nums, int l, int r){
        int i=l, j=r;
        int x = nums[i];
        while(i<j){
        		while(i<j && x<nums[j]) j--;
        		nums[i] = nums[j];
        		while(i<j && nums[i]<=x) i++;
        		nums[j] = nums[i];
        }
        nums[i] = x;
        if(l<i) quickSort0(nums,l,i-1);
        if(i<r) quickSort0(nums,i+1,r);
    }
	/*
	 * 快排，递归，选择中间的元素当做指针   面试版~~~~
	 */
	public static void quickSort1(int[] nums, int l, int r){
		int i=l, j=r; //左右指针
		int x = nums[(i+j)>>1]; //选择监督哨
		while(i<=j){
			while(nums[i] < x) i++;
			while(x < nums[j]) j--;
			if(i<=j){
				int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
				i++;
				j--;
			}
		}
		if(l<j) quickSort1(nums,l,j);
		if(i<r) quickSort1(nums,i,r);
	}
	
	/*
	 * 快速选择：选择首元素作为监督哨
	 */
    public static int findKthLargest(int[] nums, int k) {
    		k--;
        int l=0, r=nums.length-1;
        while(l<r){
        		int x = l, y = r;
        		int key = nums[x];
        		while(x<y){
        			while(x < y && key > nums[y]) y--;
        			nums[x] = nums[y];
        			while(x < y && nums[x] >= key) x++;
        			nums[y] = nums[x];
        		}
        		nums[x] = key;
        		if(x == k)
        			return nums[k];
        		else if(x > k)
        			r = x - 1;
        		else
        			l = x + 1;
        		}
        return nums[k];
    }
    /*
     * 快速选择： 选择中间元素作为监督哨
     */

    public static int findKthLargest1(int[] nums, int k){
    	k--;
    	int l=0, r= nums.length - 1;
    	while(l<r){
    		int i=l, j= r;
    		int x = nums[(i+j)>>1];
    		while(i<j){
    			while(nums[i]>x) i++;
    			while(x>nums[j]) j--;
    			if(i<=j){
    				int t=nums[i]; nums[i] = nums[j]; nums[j] = t;
    				i++;
    				j--;
    			}
    		}
    		if((l<j)&&(k<=j)) r = j;
    		else if((i<r)&&(i<=k)) l = i;
    		else return nums[k];
    	}
    	return nums[k];
    }
    
    /*
     * 快速选择：递归版快速选择  面试版~~~~
     */
    public static int findKthLargest2(int[] nums, int k){
    		return findKthLargest20(nums, k-1, 0, nums.length-1);
    }
    private static int findKthLargest20(int[] nums, int k, int l, int r){
    		int i=l, j=r;
    		int x=nums[(i+j)>>1];
    		while(i<=j){
    			while(nums[i]>x) i++;
    			while(x>nums[j]) j--;
    			if(i<=j){
    				int t = nums[i]; nums[i]=nums[j]; nums[j]=t;
    				i++;
    				j--;
    			}
    		}
    		if((l<j)&&(k<=j)) return findKthLargest20(nums,k,l,j);
    		else if ((i<r)&&(i<=k)) return findKthLargest20(nums,k,i,r);
    		else return nums[k];
    }
	
	
	public static void main(String[] args) {
		int[] nums = new int[]{6,8,3,6,2,6,4,5,3,2,1,7,3,6};
		quickSort0(nums,0,13);
		for(int i:nums){
			System.out.print(i+"_");
		}
		System.out.println();
		
		nums = new int[]{2,1};
		quickSort1(nums,0,1);
		for(int i:nums){
			System.out.print(i+"_");
		}
	}

}

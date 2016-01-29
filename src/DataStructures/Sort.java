package DataStructures;

/**
 * 排序方法 正序排序
 * @author fivemoons
 */
public final class Sort {
	/**
	 * 插入排序
	 * 稳定
	 * 空间复杂度o(1)
	 * 时间复杂度：
	 * 	最佳情况：n-1次比较，2(n-1)次移动  O(n)
	 * 	最差情况：O(n2)比较，O(n2)移动
	 * 	平均情况：O(n2)
	 * @param a
	 *            一个可比较的元素
	 */
	public static void insertionSort(Comparable[] a) {
		int j;
		for (int p = 1; p < a.length; p++) { // 数组从0开始
			Comparable tmp = a[p]; // 需要插入的项
			for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
				// 从p位置往前扫，如果tmp小于a[j-1] 空缺后移一位
				a[j] = a[j - 1];
			a[j] = tmp; // tmp放入排序的位置
		}
	}

	/**
	 * 希尔排序
	 * 
	 * @param a
	 *            一个可比较的元素
	 */
	public static void shellsort(Comparable[] a) {
		int j;
		for (int gap = a.length / 2; gap > 0; gap /= 2)
			// gap增量
			for (int i = gap; i < a.length; i++) { // 从gap开始逐个扫描
				Comparable tmp = a[i]; // 当前要比较项
				for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
					a[j] = a[j - gap];
				a[j] = tmp;
			}
	}

	/**
	 * 标准堆排序
	 * 
	 * @param a
	 *            一个可比较的元素
	 */
	public static void heapsort(Comparable[] a) {
		for (int i = a.length / 2 - 1; i >= 0; i--) //从有儿子的点开始
			percDown(a, i, a.length);// 建堆  a数组 第i个位置开始下滤，堆一共a.length长

		for (int i = a.length - 1; i > 0; i--) {
			swapReferences(a, 0, i); // 交换最大元素与最后
			percDown(a, 0, i); //i是当前元素的个数。
		}
	}

	/**
	 * 私有方法：堆排序返回左儿子
	 * 
	 * @param i
	 *            堆中的一个元素
	 * @return the index of the left child.
	 */
	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	/**
	 * 私有方法：堆排序下滤元素
	 * 
	 * @param a
	 *            一个可比较的元素
	 * @index i 要下滤的元素
	 * @int n 二项堆的大小
	 */
	private static void percDown(Comparable[] a, int i, int n) {
		int child;
		Comparable tmp;

		for (tmp = a[i]; leftChild(i) < n; i = child) { //n是堆的大小，<n表示没有越界
			child = leftChild(i);
			if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) //！=n-1表示child不是最后一个节点
				child++; //左右儿子中较大的
			if (tmp.compareTo(a[child]) < 0)
				a[i] = a[child]; //下滤一层
			else
				break;
		}
		a[i] = tmp;
	}

	/**
	 * 归并排序
	 * 
	 * @param a
	 *            一个可比较的元素
	 */
	public static void mergeSort(Comparable[] a) {
		Comparable[] tmpArray = new Comparable[a.length]; //存放归并的结果
		mergeSort(a, tmpArray, 0, a.length - 1);//归并0~a.length-1
	}

	/**
	 * 私有方法：内部递归调用
	 * 
	 * @param a
	 *            一个可比较的元素
	 * @param tmpArray
	 *            存放归并的结果
	 * @param left
	 *            左下标
	 * @param right
	 *            右下标
	 */
	private static void mergeSort(Comparable[] a, Comparable[] tmpArray,
			int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center + 1, right);
			merge(a, tmpArray, left, center + 1, right);
		}
	}

	/**
	 * 私有方法：合并两个排序好的数据
	 * 
	 * @param a
	 *            一个可比较的元素
	 * @param tmpArray
	 *            放置合并结果的数组
	 * @param leftPos
	 *            第一部分左下标
	 * @param rightPos
	 *            第二部分左下标
	 * @param rightEnd
	 *            第二部分右下标
	 */
	private static void merge(Comparable[] a, Comparable[] tmpArray,
			int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1; //第一部分右下标
		int tmpPos = leftPos; //tmp的左下标
		int numElements = rightEnd - leftPos + 1;//全部元素个数

		//主循环
		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (a[leftPos].compareTo(a[rightPos]) <= 0)
				tmpArray[tmpPos++] = a[leftPos++];
			else
				tmpArray[tmpPos++] = a[rightPos++];
		// 拷贝第一部分剩余
		while (leftPos <= leftEnd)
			tmpArray[tmpPos++] = a[leftPos++];

		// 拷贝第二部分剩余
		while (rightPos <= rightEnd)
			tmpArray[tmpPos++] = a[rightPos++];

		// 把tmp数组拷贝回a数组
		for (int i = 0; i < numElements; i++, rightEnd--)
			a[rightEnd] = tmpArray[rightEnd];
	}

	/**
	 * 快速排序
	 * 
	 * @param a
	 *            一个可比较的元素数组
	 */
	public static void quicksort(Comparable[] a) {
		quicksort(a, 0, a.length - 1); //下标 0~a.length-1
	}

	//截止大小
	private static final int CUTOFF = 3;

	/**
	 * 交换元素 用final写 编译器会自动强制直接插入的方式编译这些代码
	 * 
	 * @param a
	 *            一个Object数组
	 * @param index1
	 *            第一个元素下标
	 * @param index2
	 *            第二个元素下标
	 */
	public static final void swapReferences(Object[] a, int index1, int index2) {
		Object tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	/**
	 * 返回三个数的中位数
	 */
	private static Comparable median3(Comparable[] a, int left, int right) {
		int center = (left + right) / 2;
		if (a[center].compareTo(a[left]) < 0) // center < left
			swapReferences(a, left, center);
		if (a[right].compareTo(a[left]) < 0)  // right < left
			swapReferences(a, left, right);
		if (a[right].compareTo(a[center]) < 0) // right < center
			swapReferences(a, center, right);

		swapReferences(a, center, right - 1); //将center移动到right-1位置上
		return a[right - 1]; //返回枢纽元
	}

	/**
	 * 私有方法：递归调用，使用三个数的中位数和截止10
	 * 
	 * @param a
	 *            一个可比较的的数组
	 * @param left
	 *            左下标
	 * @param right
	 *            右下标
	 */
	private static void quicksort(Comparable[] a, int left, int right) {
		if (left + CUTOFF <= right) { //判断要排序的数目是否大于截止值
			Comparable pivot = median3(a, left, right); //返回枢纽元，并把三个数放在left,right-1,right
			
			int i = left, j = right - 1;
			for (;;) {
				while (a[++i].compareTo(pivot) < 0) {} //i右移 直到大于等于枢纽元
				while (a[--j].compareTo(pivot) > 0) {} //j左移 直到小于等于枢纽元
				if (i < j)
					swapReferences(a, i, j); //如果i<j 交换i j所指向的元素
				else
					break;
			}
			
			swapReferences(a, i, right - 1); // left~right-1已经分成两部分 枢纽元放到两部分的界线
			
			quicksort(a, left, i - 1); // 递归排序小于等于枢纽元的第一部分
			quicksort(a, i + 1, right); // 递归排序大于等于枢纽元的第二部分
		} else
			insertionSort(a, left, right); 	// 比截止数小，选择插入排序
	}

	/**
	 * 私有方法：用于快速排序中长度比cutoff小的数组的排序
	 * 
	 * @param a
	 *            一个可排序的数组
	 * @param left
	 *            左下标
	 * @param right
	 *            右下标
	 */
	private static void insertionSort(Comparable[] a, int left, int right) {
		for (int p = left + 1; p <= right; p++) { //从第二个元素开始
			Comparable tmp = a[p]; //选择范围内的首个元素
			int j;
			for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	/**
	 * 快速选择程序，第k大的数也就是下标是k-1的数
	 * 
	 * @param a
	 *            一个可比较的数组
	 * @param k
	 *            要选择的k大值
	 */
	public static void quickSelect(Comparable[] a, int k) {
		quickSelect(a, 0, a.length - 1, k);
	}

	/**
	 * 私有方法：使用快速选择来选取a[k-1]
	 * 
	 * @param a
	 *            一个可比较的数组
	 * @param left
	 *            左下标
	 * @param right
	 *            右下标
	 * @param k
	 *            要选择的k大值
	 */
	private static void quickSelect(Comparable[] a, int left, int right, int k) {
		if (left + CUTOFF <= right) {
			Comparable pivot = median3(a, left, right);
			int i = left, j = right - 1;
			for (;;) {
				while (a[++i].compareTo(pivot) < 0) {}
				while (a[--j].compareTo(pivot) > 0) {}
				if (i < j)
					swapReferences(a, i, j);
				else
					break;
			}
			swapReferences(a, i, right - 1); // 把枢纽元放到两部分中间

			if (k <= i)
				quickSelect(a, left, i - 1, k);
			else if (k > i + 1)
				quickSelect(a, i + 1, right, k);
		} else
			insertionSort(a, left, right);
	}

	private static final int NUM_ITEMS = 1000;
	private static int theSeed = 1;

	private static void checkSort(MyInteger[] a) {
		for (int i = 0; i < a.length; i++)
			if (a[i].intValue() != i)
				System.out.println("Error at " + i);
		System.out.println("Finished checksort");
	}

	public static void main(String[] args) {
		
		MyInteger[] a = new MyInteger[NUM_ITEMS];
		for (int i = 0; i < a.length; i++)
			a[i] = new MyInteger(i);

		for (theSeed = 0; theSeed < 20; theSeed++) {
			Random.permute(a);
			Sort.insertionSort(a);
			checkSort(a);

			Random.permute(a);
			Sort.heapsort(a);
			checkSort(a);

			Random.permute(a);
			Sort.shellsort(a);
			checkSort(a);

			Random.permute(a);
			Sort.mergeSort(a);
			checkSort(a);

			Random.permute(a);
			Sort.quicksort(a);
			checkSort(a);

			Random.permute(a);
			Sort.quickSelect(a, NUM_ITEMS / 2);
			System.out.println(a[NUM_ITEMS / 2 - 1].intValue() + " "
					+ NUM_ITEMS / 2);
		}
	}
}

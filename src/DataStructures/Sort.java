package DataStructures;

/**
 * ���򷽷� ��������
 * @author fivemoons
 */
public final class Sort {
	/**
	 * ��������
	 * �ȶ�
	 * �ռ临�Ӷ�o(1)
	 * ʱ�临�Ӷȣ�
	 * 	��������n-1�αȽϣ�2(n-1)���ƶ�  O(n)
	 * 	��������O(n2)�Ƚϣ�O(n2)�ƶ�
	 * 	ƽ�������O(n2)
	 * @param a
	 *            һ���ɱȽϵ�Ԫ��
	 */
	public static void insertionSort(Comparable[] a) {
		int j;
		for (int p = 1; p < a.length; p++) { // �����0��ʼ
			Comparable tmp = a[p]; // ��Ҫ�������
			for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
				// ��pλ����ǰɨ�����tmpС��a[j-1] ��ȱ����һλ
				a[j] = a[j - 1];
			a[j] = tmp; // tmp���������λ��
		}
	}

	/**
	 * ϣ������
	 * 
	 * @param a
	 *            һ���ɱȽϵ�Ԫ��
	 */
	public static void shellsort(Comparable[] a) {
		int j;
		for (int gap = a.length / 2; gap > 0; gap /= 2)
			// gap����
			for (int i = gap; i < a.length; i++) { // ��gap��ʼ���ɨ��
				Comparable tmp = a[i]; // ��ǰҪ�Ƚ���
				for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
					a[j] = a[j - gap];
				a[j] = tmp;
			}
	}

	/**
	 * ��׼������
	 * 
	 * @param a
	 *            һ���ɱȽϵ�Ԫ��
	 */
	public static void heapsort(Comparable[] a) {
		for (int i = a.length / 2 - 1; i >= 0; i--) //���ж��ӵĵ㿪ʼ
			percDown(a, i, a.length);// ����  a���� ��i��λ�ÿ�ʼ���ˣ���һ��a.length��

		for (int i = a.length - 1; i > 0; i--) {
			swapReferences(a, 0, i); // �������Ԫ�������
			percDown(a, 0, i); //i�ǵ�ǰԪ�صĸ�����
		}
	}

	/**
	 * ˽�з����������򷵻������
	 * 
	 * @param i
	 *            ���е�һ��Ԫ��
	 * @return the index of the left child.
	 */
	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	/**
	 * ˽�з���������������Ԫ��
	 * 
	 * @param a
	 *            һ���ɱȽϵ�Ԫ��
	 * @index i Ҫ���˵�Ԫ��
	 * @int n ����ѵĴ�С
	 */
	private static void percDown(Comparable[] a, int i, int n) {
		int child;
		Comparable tmp;

		for (tmp = a[i]; leftChild(i) < n; i = child) { //n�ǶѵĴ�С��<n��ʾû��Խ��
			child = leftChild(i);
			if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) //��=n-1��ʾchild�������һ���ڵ�
				child++; //���Ҷ����нϴ��
			if (tmp.compareTo(a[child]) < 0)
				a[i] = a[child]; //����һ��
			else
				break;
		}
		a[i] = tmp;
	}

	/**
	 * �鲢����
	 * 
	 * @param a
	 *            һ���ɱȽϵ�Ԫ��
	 */
	public static void mergeSort(Comparable[] a) {
		Comparable[] tmpArray = new Comparable[a.length]; //��Ź鲢�Ľ��
		mergeSort(a, tmpArray, 0, a.length - 1);//�鲢0~a.length-1
	}

	/**
	 * ˽�з������ڲ��ݹ����
	 * 
	 * @param a
	 *            һ���ɱȽϵ�Ԫ��
	 * @param tmpArray
	 *            ��Ź鲢�Ľ��
	 * @param left
	 *            ���±�
	 * @param right
	 *            ���±�
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
	 * ˽�з������ϲ���������õ�����
	 * 
	 * @param a
	 *            һ���ɱȽϵ�Ԫ��
	 * @param tmpArray
	 *            ���úϲ����������
	 * @param leftPos
	 *            ��һ�������±�
	 * @param rightPos
	 *            �ڶ��������±�
	 * @param rightEnd
	 *            �ڶ��������±�
	 */
	private static void merge(Comparable[] a, Comparable[] tmpArray,
			int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1; //��һ�������±�
		int tmpPos = leftPos; //tmp�����±�
		int numElements = rightEnd - leftPos + 1;//ȫ��Ԫ�ظ���

		//��ѭ��
		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (a[leftPos].compareTo(a[rightPos]) <= 0)
				tmpArray[tmpPos++] = a[leftPos++];
			else
				tmpArray[tmpPos++] = a[rightPos++];
		// ������һ����ʣ��
		while (leftPos <= leftEnd)
			tmpArray[tmpPos++] = a[leftPos++];

		// �����ڶ�����ʣ��
		while (rightPos <= rightEnd)
			tmpArray[tmpPos++] = a[rightPos++];

		// ��tmp���鿽����a����
		for (int i = 0; i < numElements; i++, rightEnd--)
			a[rightEnd] = tmpArray[rightEnd];
	}

	/**
	 * ��������
	 * 
	 * @param a
	 *            һ���ɱȽϵ�Ԫ������
	 */
	public static void quicksort(Comparable[] a) {
		quicksort(a, 0, a.length - 1); //�±� 0~a.length-1
	}

	//��ֹ��С
	private static final int CUTOFF = 3;

	/**
	 * ����Ԫ�� ��finalд ���������Զ�ǿ��ֱ�Ӳ���ķ�ʽ������Щ����
	 * 
	 * @param a
	 *            һ��Object����
	 * @param index1
	 *            ��һ��Ԫ���±�
	 * @param index2
	 *            �ڶ���Ԫ���±�
	 */
	public static final void swapReferences(Object[] a, int index1, int index2) {
		Object tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	/**
	 * ��������������λ��
	 */
	private static Comparable median3(Comparable[] a, int left, int right) {
		int center = (left + right) / 2;
		if (a[center].compareTo(a[left]) < 0) // center < left
			swapReferences(a, left, center);
		if (a[right].compareTo(a[left]) < 0)  // right < left
			swapReferences(a, left, right);
		if (a[right].compareTo(a[center]) < 0) // right < center
			swapReferences(a, center, right);

		swapReferences(a, center, right - 1); //��center�ƶ���right-1λ����
		return a[right - 1]; //������ŦԪ
	}

	/**
	 * ˽�з������ݹ���ã�ʹ������������λ���ͽ�ֹ10
	 * 
	 * @param a
	 *            һ���ɱȽϵĵ�����
	 * @param left
	 *            ���±�
	 * @param right
	 *            ���±�
	 */
	private static void quicksort(Comparable[] a, int left, int right) {
		if (left + CUTOFF <= right) { //�ж�Ҫ�������Ŀ�Ƿ���ڽ�ֵֹ
			Comparable pivot = median3(a, left, right); //������ŦԪ����������������left,right-1,right
			
			int i = left, j = right - 1;
			for (;;) {
				while (a[++i].compareTo(pivot) < 0) {} //i���� ֱ�����ڵ�����ŦԪ
				while (a[--j].compareTo(pivot) > 0) {} //j���� ֱ��С�ڵ�����ŦԪ
				if (i < j)
					swapReferences(a, i, j); //���i<j ����i j��ָ���Ԫ��
				else
					break;
			}
			
			swapReferences(a, i, right - 1); // left~right-1�Ѿ��ֳ������� ��ŦԪ�ŵ������ֵĽ���
			
			quicksort(a, left, i - 1); // �ݹ�����С�ڵ�����ŦԪ�ĵ�һ����
			quicksort(a, i + 1, right); // �ݹ�������ڵ�����ŦԪ�ĵڶ�����
		} else
			insertionSort(a, left, right); 	// �Ƚ�ֹ��С��ѡ���������
	}

	/**
	 * ˽�з��������ڿ��������г��ȱ�cutoffС�����������
	 * 
	 * @param a
	 *            һ�������������
	 * @param left
	 *            ���±�
	 * @param right
	 *            ���±�
	 */
	private static void insertionSort(Comparable[] a, int left, int right) {
		for (int p = left + 1; p <= right; p++) { //�ӵڶ���Ԫ�ؿ�ʼ
			Comparable tmp = a[p]; //ѡ��Χ�ڵ��׸�Ԫ��
			int j;
			for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	/**
	 * ����ѡ����򣬵�k�����Ҳ�����±���k-1����
	 * 
	 * @param a
	 *            һ���ɱȽϵ�����
	 * @param k
	 *            Ҫѡ���k��ֵ
	 */
	public static void quickSelect(Comparable[] a, int k) {
		quickSelect(a, 0, a.length - 1, k);
	}

	/**
	 * ˽�з�����ʹ�ÿ���ѡ����ѡȡa[k-1]
	 * 
	 * @param a
	 *            һ���ɱȽϵ�����
	 * @param left
	 *            ���±�
	 * @param right
	 *            ���±�
	 * @param k
	 *            Ҫѡ���k��ֵ
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
			swapReferences(a, i, right - 1); // ����ŦԪ�ŵ��������м�

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

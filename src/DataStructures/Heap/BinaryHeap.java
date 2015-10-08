package DataStructures.Heap;

import DataStructures.Comparable;
import DataStructures.MyInteger;
import DataStructures.Overflow;

// BinaryHeap class
//
// CONSTRUCTION: with optional capacity (that defaults to 100)
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// boolean isFull( )      --> Return true if full; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Throws Overflow if capacity exceeded

/**
 * Implements a binary heap. Note that all "matching" is based on the compareTo
 * method.
 * 
 */
public class BinaryHeap {
	/**
	 * 构造器
	 */
	public BinaryHeap() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 构造器
	 * 
	 * @param capacity
	 *            the capacity of the binary heap.
	 */
	public BinaryHeap(int capacity) {
		currentSize = 0;
		array = new Comparable[capacity + 1];
	}

	/**
	 * 插入堆，维护堆，允许重复
	 * 
	 * @param x
	 *            the item to insert.
	 * @exception Overflow
	 *                if container is full.
	 */
	public void insert(Comparable x) throws Overflow {
		if (isFull())
			throw new Overflow();

		// 上滤
		int hole = ++currentSize;
		for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
			array[hole] = array[hole / 2];
		array[hole] = x;
	}

	/**
	 * 找到最小的元素
	 * 
	 * @return the smallest item, or null, if empty.
	 */
	public Comparable findMin() {
		if (isEmpty())
			return null;
		return array[1];
	}

	/**
	 * 删除最小的元素，根元素，然后执行下滤
	 * 
	 * @return the smallest item, or null, if empty.
	 */
	public Comparable deleteMin() {
		if (isEmpty())
			return null;

		Comparable minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);

		return minItem;
	}

	/**
	 * 建堆
	 * Runs in linear time.
	 */
	private void buildHeap() {
		for (int i = currentSize / 2; i > 0; i--)
			percolateDown(i);
	}

	/**
	 * Test if the priority queue is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return currentSize == 0;
	}

	/**
	 * Test if the priority queue is logically full.
	 * 
	 * @return true if full, false otherwise.
	 */
	public boolean isFull() {
		return currentSize == array.length - 1;
	}

	/**
	 * Make the priority queue logically empty.
	 */
	public void makeEmpty() {
		currentSize = 0;
	}

	private static final int DEFAULT_CAPACITY = 100;

	private int currentSize; // Number of elements in heap
	private Comparable[] array; // The heap array

	/**
	 * 私有方法：下滤
	 * 
	 * @param hole
	 *            开始下滤的元素下标。
	 */
	private void percolateDown(int hole) {
		int child;
		Comparable tmp = array[hole];

		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2; //hole的左儿子
			if (child != currentSize
					&& array[child + 1].compareTo(array[child]) < 0)
				child++; //返回儿子中较小的
			if (array[child].compareTo(tmp) < 0)
				array[hole] = array[child]; //较小的儿子当父节点，hole下移。
			else
				break;
		}
		array[hole] = tmp;
	}

	// Test program
	public static void main(String[] args) {
		int numItems = 10000;
		BinaryHeap h = new BinaryHeap(numItems);
		int i = 37;

		try {
			for (i = 37; i != 0; i = (i + 37) % numItems)
				h.insert(new MyInteger(i));
			for (i = 1; i < numItems; i++)
				if (((MyInteger) (h.deleteMin())).intValue() != i)
					System.out.println("Oops! " + i);

			for (i = 37; i != 0; i = (i + 37) % numItems)
				h.insert(new MyInteger(i));
			h.insert(new MyInteger(0));
			i = 9999999;
			h.insert(new MyInteger(i));
			for (i = 1; i <= numItems; i++)
				if (((MyInteger) (h.deleteMin())).intValue() != i)
					System.out.println("Oops! " + i + " ");
		} catch (Overflow e) {
			System.out.println("Overflow (expected)! " + i);
		}
	}
}

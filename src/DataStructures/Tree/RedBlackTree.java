package DataStructures.Tree;

import DataStructures.Comparable;
import DataStructures.MyInteger;

//红黑树
//
// CONSTRUCTION: with a negative infinity sentinel
//
// ******************public 方法*********************
// void insert( x )       --> 插入数据 x
// void remove( x )       --> 删除数据 x (unimplemented)
// Comparable find( x )   --> 寻找 x
// Comparable findMin( )  --> 返回最小的元素
// Comparable findMax( )  --> 返回最大的元素
// boolean isEmpty( )     --> 返回树是否为空
// void makeEmpty( )      --> 移除所有数据
// void printTree( )      --> 打印数据

/**
 * 实现了一个红黑树
 * 
 * @author fivemoons
 */
public class RedBlackTree {
	private enum Color{
		Red,
		Black
	}
	private RedBlackNode header; //根结点
	private static RedBlackNode nullNode; //空节点

	static{ //静态代码块，
		nullNode = new RedBlackNode(null); //当前设为空
		nullNode.left = nullNode.right = nullNode; //左右也设为空
	}
	
	static final int BLACK = 1; //黑节点 1
	static final int RED = 0;  //红节点 0
	
	private static RedBlackNode current; //当前节点
	private static RedBlackNode parent; //父节点
	private static RedBlackNode grand; //祖父节点
	private static RedBlackNode great;
	/**
	 * 构造函数
	 * @param negInf	 新建一个数据点
	 */
	public RedBlackTree(Comparable negInf) {
		header = new RedBlackNode(negInf);
		header.left = header.right = nullNode;
	}

	/**
	 * 插入一个数据到红黑树中，如果元素存在，则不再重复插入
	 * @param item  要插入的数据
	 */
	public void insert(Comparable item) {
		current = parent = grand = header;
		nullNode.element = item;

		while (current.element.compareTo(item) != 0) {
			great = grand;
			grand = parent;
			parent = current;
			current = item.compareTo(current.element) < 0 ? current.left : current.right;

			// Check if two red children; fix if so
			if (current.left.color == RED && current.right.color == RED)
				handleReorient(item);
		}

		// Insertion fails if already present
		if (current != nullNode)
			return;
		current = new RedBlackNode(item, nullNode, nullNode);

		// Attach to parent
		if (item.compareTo(parent.element) < 0)
			parent.left = current;
		else
			parent.right = current;
		handleReorient(item);
	}

	/**
	 * 删除一个节点
	 * @param x 需要删除的点
	 */
	public void remove(Comparable x) {
		System.out.println("Remove is not implemented");
	}

	/**
	 * 返回最小的数
	 * @return 返回最小值 或 null
	 */
	public Comparable findMin() {
		if (isEmpty())
			return null;

		RedBlackNode itr = header.right;

		while (itr.left != nullNode)
			itr = itr.left;

		return itr.element;
	}

	/**
	 * 返回最大的数
	 * 
	 * @return the largest item or null if empty.
	 */
	public Comparable findMax() {
		if (isEmpty())
			return null;

		RedBlackNode itr = header.right;

		while (itr.right != nullNode)
			itr = itr.right;

		return itr.element;
	}

	/**
	 * Find an item in the tree.
	 * 
	 * @param x
	 *            the item to search for.
	 * @return the matching item or null if not found.
	 */
	public Comparable find(Comparable x) {
		nullNode.element = x;
		current = header.right;

		for (;;) {
			if (x.compareTo(current.element) < 0)
				current = current.left;
			else if (x.compareTo(current.element) > 0)
				current = current.right;
			else if (current != nullNode)
				return current.element;
			else
				return null;
		}
	}

	/**
	 * 设为空红黑树
	 */
	public void makeEmpty() {
		header.right = nullNode;
	}

	/**
	 * Test if the tree is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return header.right == nullNode;
	}

	/**
	 * Print the tree contents in sorted order.
	 */
	public void printTree() {
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(header.right);
	}

	/**
	 * Internal method to print a subtree in sorted order.
	 * 
	 * @param t
	 *            the node that roots the tree.
	 */
	private void printTree(RedBlackNode t) {
		if (t != nullNode) { //
			printTree(t.left); //打印左节点
			System.out.println(t.element);
			printTree(t.right); //打印右结点
		}
	}

	/**
	 * Internal routine that is called during an insertion if a node has two red
	 * children. Performs flip and rotations.
	 * 
	 * @param item
	 *            the item being inserted.
	 */
	private void handleReorient(Comparable item) {
		// Do the color flip
		current.color = RED;
		current.left.color = BLACK;
		current.right.color = BLACK;

		if (parent.color == RED) // Have to rotate
		{
			grand.color = RED;
			if ((item.compareTo(grand.element) < 0) != (item.compareTo(parent.element) < 0))
				parent = rotate(item, grand); // Start dbl rotate
			current = rotate(item, great);
			current.color = BLACK;
		}
		header.right.color = BLACK; // Make root black
	}

	/**
	 * Internal routine that performs a single or double rotation. Because the
	 * result is attached to the parent, there are four cases. Called by
	 * handleReorient.
	 * 
	 * @param item
	 *            the item in handleReorient.
	 * @param parent
	 *            the parent of the root of the rotated subtree.
	 * @return the root of the rotated subtree.
	 */
	private RedBlackNode rotate(Comparable item, RedBlackNode parent) {
		if (item.compareTo(parent.element) < 0)
			return parent.left = item.compareTo(parent.left.element) < 0 ? rotateWithLeftChild(parent.left)
					: // LL
					rotateWithRightChild(parent.left); // LR
		else
			return parent.right = item.compareTo(parent.right.element) < 0 ? rotateWithLeftChild(parent.right)
					: // RL
					rotateWithRightChild(parent.right); // RR
	}

	/**
	 * Rotate binary tree node with left child.
	 */
	static RedBlackNode rotateWithLeftChild(RedBlackNode k2) {
		RedBlackNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		return k1;
	}
	/**
	 * Rotate binary tree node with right child.
	 */
	static RedBlackNode rotateWithRightChild(RedBlackNode k1) {
		RedBlackNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		return k2;
	}

	// Test program
	public static void main(String[] args) {
		RedBlackTree t = new RedBlackTree(new MyInteger(Integer.MIN_VALUE));
		final int NUMS = 40000;
		final int GAP = 307;

		System.out.println("Checking... (no more output means success)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
			t.insert(new MyInteger(i));

		if (NUMS < 40)
			t.printTree();
		if (((MyInteger) (t.findMin())).intValue() != 1 || ((MyInteger) (t.findMax())).intValue() != NUMS - 1)
			System.out.println("FindMin or FindMax error!");

		for (int i = 1; i < NUMS; i++)
			if (((MyInteger) (t.find(new MyInteger(i)))).intValue() != i)
				System.out.println("Find error1!");
	}
}

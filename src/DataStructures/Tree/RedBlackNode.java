package DataStructures.Tree;

import DataStructures.Comparable;

//红黑树的节点
//包访问权限
class RedBlackNode {
	//构造方法
	RedBlackNode(Comparable theElement) {
		this(theElement, null, null);
	}
	//构造方法
	RedBlackNode(Comparable theElement, RedBlackNode lt, RedBlackNode rt) {
		element = theElement;
		left = lt;
		right = rt;
		color = RedBlackTree.BLACK;
	}

	//属性
	Comparable element; //存放的数据
	RedBlackNode left; //左儿子
	RedBlackNode right; //右儿子
	int color; //颜色
}

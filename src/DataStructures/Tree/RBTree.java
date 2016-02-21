package DataStructures.Tree;

enum Color{
	RED,
	BLACK
}

class Node{
	int val;
	Node par;
	Node left;
	Node right;
	Color color;
	Node(int val,Node par,Color color){
		this.val = val;
		this.par = par;
		this.left = null;
		this.right = null;
		this.color = color;
	}
}

public class RBTree{
	private static final Color Black = Color.BLACK;
	private static final Color Red = Color.RED;
	private Node root;
	
	public boolean insert(int x){
		if(root == null){
			root = new Node(x,null,Black);
			return true;
		}else{
			for(Node cur = root;;){
				if (x < cur.val){ //插入小节点
					if (cur.left == null){ //找到
						cur.left = new Node(x,cur,Red);
						insertFix(cur.left);
						return true;
					}else
						cur = cur.left;
				}else if(cur.val < x){ //插入大节点
					if (cur.right == null){ //找到
						cur.right = new Node(x,cur,Red);
						insertFix(cur.right);
						return true;
					}else
						cur = cur.right;
				}else //重复插入
					return false;
			}
		}
	}
	private Node rightRotate(Node A){
		Node P = A.par;
		Node B = A.left;
		Node D = B.right;
		if(root == A) root = B;
		
		if(P!=null && P.left == A) P.left = B;
		if(P!=null && P.right == A) P.right = B;
		B.par = P;
		
		A.par = B;
		B.right = A;
		
		A.left = D;
		if(D!=null) D.par = A;
		return B;
	}
	private Node leftRotate(Node A){
		Node P = A.par;
		Node C = A.right;
		Node D = C.left;
		if(root == A) root = C;
		
		if(P!=null && P.left == A) P.left = C;
		if(P!=null && P.right == A) P.right = C;
		C.par = P;
		
		A.par = C;
		C.left = A;
		
		A.right = D;
		if(D!=null) D.par = A;
		return C;
	}
	private void insertFix(Node cur){
		if(cur.par.color == Black) return; //case0:当前红，父黑，返回
		while(cur.par != null && cur.par.color == Red){
			Node P = cur.par;
			Node G = cur.par.par;
			Node U = P == G.left ? G.right : G.left;
			if(U != null && U.color == Red){//case1：当前红，父红，叔红
				P.color = Black;//case1: 父变黑
				U.color = Black;//case1: 叔变黑
				G.color = Red;//case1: 祖变红
				cur = G;//case1: 递归祖
			}else{//case2 or 3
				if(P == G.left){//父是左儿子
					if(cur == P.right){//case2: 当前红，父红，叔黑，当前是右儿子
						cur = P; //case2: 父设为当前
						leftRotate(cur); //case2:左旋父节点 转换为case3
					}else{
						//case3: 当前红，父红，叔黑，当前是左儿子
						P.color = Black; //case3: 父变黑
						G.color = Red; //case3: 祖变红
						rightRotate(G); //case3: 右旋祖父节点
					}
				}else{//父是右儿子，左右互换
					if(cur == P.left){
						cur = P;
						rightRotate(cur);
					}else{
						P.color = Black;
						G.color = Red;
						leftRotate(G);
					}
				}
			}
		}
		root.color = Black;
	}
	private void print(Node root,int dep){
		if (root == null) return;
		print(root.right,dep+1);
		for(int i=0; i<dep; i++){
			System.out.print('\t');
		}
		System.out.println(root.color + "_" + root.val);
		print(root.left,dep+1);
	}
	public void print(){
		print(root,0);
	}
	public static void main(String[] args) {
		RBTree tree = new RBTree();
		tree.insert(12);
		tree.insert(1);
		tree.insert(9);
		tree.insert(2);
		tree.insert(0);
		tree.insert(11);
		tree.insert(7);
		tree.insert(19);
		tree.insert(4);
		tree.insert(15);
		tree.insert(18);
		tree.insert(5);
		tree.insert(14);
		tree.insert(13);
		tree.insert(10);
		tree.insert(16);
		tree.insert(6);
		tree.insert(3);
		tree.insert(8);
		tree.insert(17);
		tree.print();
	}
}
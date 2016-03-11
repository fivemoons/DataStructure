package Tree;

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
	public boolean delete(int x){
		Node del = root;
		while(del != null && del.val != x){
			if(x < del.val)
				del = del.left;
			else if(del.val < x)
				del = del.right;
		}
		if(del == null)
			return false;
		else{
			Node P = del.par;
			Node next = null;
			if(del.left == null && del.right == null){//叶子节点
				next = null; //接替节点为null
				if(P == null) root = null;
				if(P != null && P.left == del){ //是父左儿子
					P.left = null;
				}else if(P != null && P.right == del){ //是父右儿子
					P.right = null;
				}
				del.par = null; //去掉父节点
			}else if (del.left != null && del.right == null){//只有左儿子
				next = del.left;
				if(P == null) root = next;
				if(P != null && P.left == del){//是父左儿子
					P.left = del.left;
				}else if(P != null && P.right == del){//是父右儿子
					P.right = del.left;
				}
				del.left.par = P;
				del.par = null;
				del.left = null;
			}else if (del.right != null && del.left == null){//只有右儿子
				next = del.right;
				if(P == null) root = next;
				if(P != null && P.left == del){
					P.left = del.right;
				}else if(P != null && P.right == del){
					P.right = del.right;
				}
				del.right.par = P;
				del.par = null;
				del.right = null;
			}else{ //del.right != null && del.left != null
				Node min = findMin(del.right);
				del.val = min.val;
				
				next = min.right;
				P = min.par;
				
				if (P==del)
					P.right = min.right;
				else
					P.left = min.right;
				
				if (next != null){
					next.par = P;
				}
				min.right = null;
				min.par = null;
				del = min;
			}
			//min是一个孤独的点，已经被删了，next是一个补位点 ：所以 next->del 红+黑 或 黑+黑
			if (!isBlack(next) && isBlack(del)){
				next.color = Black;
			}else if (isBlack(next) && isBlack(del) && P != null){
				deleteFix(next,P);
			}
			//any+红 不用
			return true;
		}
	}
	private boolean isBlack(Node x){
		return x==null || x.color == Black;
	}
	private void deleteFix(Node cur,Node Par){
		while(cur != root && isBlack(cur)){
			Node P = (cur == null) ? Par : cur.par; //cur不是根 P肯定存在
			Node B = null;
			Node C1 = null;
			Node C2 = null;
			if(P.left == cur){ //cur是P的左儿子
				B = P.right;
				if(!isBlack(B)){//case1：变成case2
					B.color = Black; //case1：兄弟变黑
					P.color = Red;//case1：父变红
					leftRotate(P);//case1：父左旋
					//System.out.println("case1");
				}else{//case2，3，4
					C1 = B.left; //大侄子
					C2 = B.right; //二侄子
					if(isBlack(C1) && isBlack(C2)){//case2：递归父
						B.color = Red; //case2：兄弟变红
						cur = P; //case2：递归P
						//System.out.println("case2");
					}else if((!isBlack(C1)) && isBlack(C2)){//case3：变为case4 C1肯定为Red
						C1.color = Black; //case3：大侄子变黑
						B.color = Red; //case3：兄弟变红
						rightRotate(B); //case3：兄弟右旋
						//System.out.println("case3");
					}else{ //case4：C1随意，C2为红
						B.color = P.color; //case4：兄变父
						P.color = Black; //case4：父变黑
						C2.color = Black; //case4：二侄子变黑
						leftRotate(P); //case4：父左旋
						cur = root; //算法结束
						//System.out.println("case4");
					}
				}
			}else{//cur是P的右儿子
				B = P.left;
				if(!isBlack(B)){//case1：变成case2
					B.color = Black; //case1：兄弟变黑
					P.color = Red;//case1：父变红
					rightRotate(P);//case1：父右旋
				}else{//case2，3，4
					C1 = B.right; //小侄子
					C2 = B.left; //大侄子
					if(isBlack(C1) && isBlack(C2)){//case2：递归父
						B.color = Red; //case2：兄弟变红
						cur = P; //case2：递归P
					}else if((!isBlack(C1)) && isBlack(C2)){//case3：变为case4 C1肯定为Red
						C1.color = Black; //case3：大侄子变黑
						B.color = Red; //case3：兄弟变红
						leftRotate(B); //case3：兄弟左旋
					}else{ //case4：C1随意，C2为红
						B.color = P.color; //case4：兄变父
						P.color = Black; //case4：父变黑
						C2.color = Black; //case4：二侄子变黑
						rightRotate(P); //case4：父右旋
						cur = root; //算法结束
					}
				}
			}
		}
		cur.color = Black;
	}
	public Node findMin(Node root){
		if (root == null) return null;
		Node ans = root;
		while(ans.left!=null)
			ans = ans.left;
		return ans;
	}
	
	public Node findMax(Node root){
		if (root == null) return null;
		Node ans = root;
		while(ans.right!=null)
			ans = ans.right;
		return ans;
	}
	
	public Node find(int x){
		Node ans = root;
		while(ans!=null){
			if (x < ans.val)
				ans = ans.left;
			else if(ans.val < x)
				ans = ans.right;
			else
				return ans;
		}
		return null;
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
		tree.delete(12);
		tree.delete(1);
		tree.delete(9);
		tree.delete(2);
		tree.delete(0);
		tree.delete(11);
		tree.delete(7);
		tree.delete(19);
		tree.delete(4);
		tree.delete(15);
		tree.delete(18);
		tree.delete(5);
		tree.delete(14);
		tree.delete(13);
		tree.delete(10);
		tree.delete(16);
		tree.delete(6);
		tree.delete(3);
		tree.delete(8);
		tree.delete(17);
		tree.print();
	}
}
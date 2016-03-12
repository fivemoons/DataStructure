package Tree;

public class BSTreeToLinkedList {
	class Node{
		int val;
		Node left;
		Node right;
	}
	private Node last; //存放上一个节点的位置
	private Node head; //存放返回链表的head
	public void toLinkedList(Node root){
		if (root==null) return;
		if (root.left != null){
			toLinkedList(root.left); //递归左子树
		}
		
		if(last != null){ //如果有last
			last.right = root; //和当前节点拼起来
			root.left = last;
		}else{ //当前节点是第一个节点
			head = root; //找到第一个节点
		}
		last = root; //转移下一个点
		
		if (root.right != null){
			toLinkedList(root.right); //递归右子树
		}
	}
	public void print(){
		for(Node temp = head; temp!=null; temp = temp.right)
			System.out.print(temp.val+"_");
	}
}

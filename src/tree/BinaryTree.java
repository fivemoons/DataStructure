package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
	public static List<Integer> preOrderTraversalWithoutRecursion(TreeNode root){
		List<Integer> ans = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p != null || !stack.isEmpty()){
			if(p != null){
				ans.add(p.val); //前序遍历入栈就加入到ans中
				stack.push(p);
				p = p.left;
			}else{
				p = stack.pop();
				p = p.right;
			}
		}
		return ans;
	}
	
	public static List<Integer> midOrderTraversalWithoutRecursion(TreeNode root){
		List<Integer> ans = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p != null || !stack.isEmpty()){
			if(p != null){
				stack.push(p);
				p = p.left;
			}else{
				p = stack.pop();
				ans.add(p.val); //中序遍历出栈加入到ans中
				p = p.right;
			}
		}
		return ans;
	}
	
	public static List<Integer> postOrderTraversalWithoutRecursion(TreeNode root) {
		List<Integer> ans = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode last = null;
		while (p != null || !stack.isEmpty()){
			if(p != null){
				stack.push(p);
				p = p.left;
			}else{
				if(stack.peek().right == null || stack.peek().right == last){ //右儿子不需要遍历
					last = stack.pop();
					ans.add(last.val);
				}else{
					p = stack.peek().right; //右儿子需要遍历
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.left.right = new TreeNode(4);
		t.right.left = new TreeNode(5);
		
		List<Integer> test1 = preOrderTraversalWithoutRecursion(t);
		List<Integer> test2 = midOrderTraversalWithoutRecursion(t);
		List<Integer> test3 = postOrderTraversalWithoutRecursion(t);
		
		System.out.println("前序遍历:");
		for(Integer i:test1){
			System.out.print(i+" ");
		}
		System.out.println();
		
		System.out.println("中序遍历:");
		for(Integer i:test2){
			System.out.print(i+" ");
		}
		System.out.println();
		
		System.out.println("后序遍历:");
		for(Integer i:test3){
			System.out.print(i+" ");
		}
		System.out.println();
		
	}

}

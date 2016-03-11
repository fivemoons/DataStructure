package Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		this.val = x;
	}
}
public class BinaryTree {
	public static List<Integer> preOrderTraversalWithoutRecursion(TreeNode root){
		List<Integer> ans = new LinkedList<Integer>();
		if(root == null) return ans;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || !stack.isEmpty()){
			if(root == null){
				root = stack.pop().right;
			}else{
				stack.push(root);
				ans.add(root.val); //前序遍历入栈就加入到ans中
				root = root.left;
			}
		}
		return ans;
	}
	
	public static List<Integer> midOrderTraversalWithoutRecursion(TreeNode root){
		List<Integer> ans = new LinkedList<Integer>();
		if(root == null) return ans;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || !stack.isEmpty()){
			if(root == null){
				ans.add(stack.peek().val); //中序遍历出栈加入到ans中
				root = stack.pop().right;
			}else{
				stack.push(root);
				root = root.left;
			}
		}
		return ans;
	}
	
	public static List<Integer> postOrderTraversalWithoutRecursion2(TreeNode root){
		List<Integer> ans = new LinkedList<Integer>(); //存放最终答案
		if(root == null) return ans; //空指针
		
		Stack<TreeNode> stack = new Stack<TreeNode>(); 
		Set<TreeNode> set = new HashSet<TreeNode>();
		
		while(root != null || !stack.empty()){
			if(root == null){
				if(!set.contains(stack.peek())){
					set.add(stack.peek());
					root = stack.peek().right;
				}else{
					ans.add(stack.pop().val);
				}
			}else{
				stack.push(root);
				root = root.left;
			}
		}
		
		return ans;
	}
	
	public static List<Integer> postOrderTraversalWithoutRecursion(TreeNode root) {
		List<Integer> ans = new LinkedList<Integer>();
		if (root == null) return ans;
		TreeNode last = null;	
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()){
			if(root == null){
				if(stack.peek().right == null || stack.peek().right == last){
					last = stack.pop();
					ans.add(last.val);
				}else{
					root = stack.peek().right;
				}
			}else{
				stack.push(root);
				root = root.left;

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
		List<Integer> test3 = postOrderTraversalWithoutRecursion2(t);
		
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
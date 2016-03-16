package tree;

import java.util.Arrays;

public class BuildTree {
	public static TreeNode buildTree0(int[] preorder, int[] inorder){
		if(preorder.length == 0 || inorder.length == 0) return null;
		TreeNode root = new TreeNode(preorder[0]);
		int i=0;
		for(i=0; i<inorder.length; i++){
			if (inorder[i] == root.val) break;
		}
		int[] prel = Arrays.copyOfRange(preorder,1  ,i+1);
		int[] prer = Arrays.copyOfRange(preorder,i+1,preorder.length);
		int[] inl  = Arrays.copyOfRange(inorder ,0  ,i);
		int[] inr  = Arrays.copyOfRange(inorder ,i+1,inorder.length);
		
		root.left = buildTree0(prel, inl);
		root.right = buildTree0(prer,inr);
		return root;
	}
	public static TreeNode buildTree1(int[] inorder, int[] postorder){
		if(inorder.length == 0 || postorder.length == 0) return null;
		TreeNode root = new TreeNode(postorder[postorder.length-1]);
		int i=0;
		for(i=0; i<inorder.length; i++){
			if (inorder[i] == root.val) break;
		}
		int[] inl   = Arrays.copyOfRange(inorder ,   0, i);
		int[] inr   = Arrays.copyOfRange(inorder , i+1, inorder.length);
		int[] postl = Arrays.copyOfRange(postorder,  0, i);
		int[] postr = Arrays.copyOfRange(postorder,  i, postorder.length-1);
		
		root.left  = buildTree1(inl,postl);
		root.right = buildTree1(inr,postr);
		return root;
	}
	public static void main(String[] args) {
		int[] preorder  = {1,2,4,7,3,5,6,8};
		int[] inorder   = {4,7,2,1,5,3,8,6};
		int[] postorder = {7,4,2,5,8,6,3,1};
		TreeNode t0 = buildTree0(preorder,  inorder);
		TreeNode t1 = buildTree1(inorder, postorder);
		System.out.println(t0.val + "_" + t1.val);
		System.out.println(t0.right.right.left.val + "_" + t1.right.right.left.val);
	}

}

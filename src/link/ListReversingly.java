package link;

import java.util.Stack;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;};
}

public class ListReversingly {
	public static void ListReversingly_I(ListNode head){
		Stack<ListNode> stack = new Stack<ListNode>();
		for(ListNode t = head; t != null; t = t.next){
			stack.push(t);
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().val+"_");
		}
		System.out.println();
	}
	public static void ListReversingly_R(ListNode head){
		if(head!=null){
			ListReversingly_R(head.next);
			System.out.print(head.val+"_");
		}
	}
	public static void main(String[] args) {
		ListNode t1 = new ListNode(1);
		t1.next = new ListNode(2);
		t1.next.next = new ListNode(3);
		t1.next.next.next = new ListNode(4);
		ListReversingly_I(t1);
		ListReversingly_R(t1);
	}

}

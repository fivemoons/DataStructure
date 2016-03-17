package stack;
import java.util.Stack;
public class minStack {
	private Stack<Integer> stk1 = new Stack<Integer>();
	private Stack<Integer> stk2 = new Stack<Integer>();
	
	public void push(int node) {
        stk1.push(node);
        stk2.push(!stk2.empty() && stk2.peek() < node ? stk2.peek() : node);
    }
    
    public void pop() {
        stk1.pop();
        stk2.pop();
    }
    
    public int top() {
        return stk1.peek();
    }
    
    public int min() {
        return stk2.peek();
    }

}

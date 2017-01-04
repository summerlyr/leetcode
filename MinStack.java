
import java.util.Stack;

public class MinStack {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minstack = new Stack<Integer>();

	public void push(int x) {
		stack.push(x);
		if (minstack.isEmpty() || x <= minstack.peek()) {
			minstack.push(x);
		}
	}

	public void pop() {
		if (stack.isEmpty()) {
			return;
		} else {
			if (stack.peek().equals(minstack.peek())) {
				minstack.pop();
			}
			stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minstack.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack();
		ms.push(512);
		ms.push(-1024);
		ms.push(-1024);
		ms.push(512);
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());

	}

}

import java.util.Stack;

public class ImplementQueueusingStacks {

	Stack<Integer> first = new Stack<Integer>();
	Stack<Integer> second = new Stack<Integer>();
	int top;

	// Push element x to the back of queue.
	public void push(int x) {
		first.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		while (first.size() > 1) {
			second.push(first.pop());
		}
		first.pop();
		while (!second.isEmpty()) {
			first.push(second.pop());
		}
	}

	// Get the front element.
	public int peek() {
		while (!first.isEmpty()) {
			top = first.pop();
			second.push(top);
		}
		while (!second.isEmpty()) {
			first.push(second.pop());
		}
		return top;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return first.isEmpty();
	}

	/*
	 * Stack<Integer> first = new Stack<Integer>(); Stack<Integer> second = new
	 * Stack<Integer>(); int top; // Push element x to the back of queue. public
	 * void push(int x) { first.push(x); }
	 * 
	 * // Removes the element from in front of queue. public void pop() {
	 * shift(); second.pop(); }
	 * 
	 * // Get the front element. public int peek() { shift(); return
	 * second.peek(); }
	 * 
	 * // Return whether the queue is empty. public boolean empty() { return
	 * first.isEmpty()&&second.isEmpty(); }
	 * 
	 * //Move elements from first to second public void shift() {
	 * if(second.isEmpty()) { while(!first.isEmpty()) { second.add(first.pop());
	 * } } }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

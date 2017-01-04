import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {

	Queue<Integer> queue = new LinkedList<Integer>();
	Queue<Integer> tmp = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		queue.add(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		while (queue.size() > 1) {
			tmp.add(queue.poll());
		}
		queue.poll();
		while (!tmp.isEmpty()) {
			queue.add(tmp.poll());
		}
	}

	// Get the top element.
	public int top() {
		int top = 0;
		while (!queue.isEmpty()) {
			top = queue.peek();
			tmp.add(queue.poll());
		}
		while (!tmp.isEmpty()) {
			queue.add(tmp.poll());
		}
		return top;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}

	/*
	 * Queue<Integer> queue = new LinkedList<Integer>(); public void push(int x)
	 * { queue.add(x); for(int i=0;i<queue.size()-1;i++) {
	 * queue.add(queue.poll()); } } // Removes the element on top of the stack.
	 * public void pop() { queue.poll(); }
	 * 
	 * // Get the top element. public int top() { return queue.peek(); }
	 * 
	 * // Return whether the stack is empty. public boolean empty() { return
	 * queue.isEmpty(); }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

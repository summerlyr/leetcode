import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

	Stack<NestedInteger> stack;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new Stack<NestedInteger>();
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger cur = stack.peek();
			if (cur.isInteger())
				return true;
			stack.pop();
			for (int i = cur.getList().size() - 1; i >= 0; i--) {
				stack.push(cur.getList().get(i));
			}
		}
		return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}
}

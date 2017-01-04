import java.util.Stack;

public class BinarySearchTreeIterator {

	Stack<Integer> minstack = new Stack<Integer>();

	public BinarySearchTreeIterator(TreeNode root) {
		addAll(root);
	}

	public void addAll(TreeNode root) {
		if (root == null) {
			return;
		}
		addAll(root.right);
		minstack.add(root.val);
		addAll(root.left);
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return !minstack.isEmpty();
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		return minstack.pop();
	}

	/*
	 * Stack<TreeNode> stack = new Stack<TreeNode>(); public
	 * BSTIterator(TreeNode root) { pushAll(root); }
	 * 
	 * 
	 * public boolean hasNext() { return !stack.isEmpty(); }
	 * 
	 * 
	 * public int next() { TreeNode cur = stack.pop(); pushAll(cur.right);
	 * return cur.val; }
	 * 
	 * public void pushAll(TreeNode root) { while(root!=null) {
	 * stack.push(root); root = root.left; } }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

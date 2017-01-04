import java.util.Stack;

public class LargestRectangleinHistogram {

	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i <= height.length; i++) {
			int h = (i == height.length) ? 0 : height[i];
			while (!stack.isEmpty() && h < height[stack.peek()]) {
				int rect = height[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
				max = Math.max(max, rect);
			}
			stack.push(i);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> number = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				int second = number.pop();
				int first = number.pop();
				if (tokens[i].equals("+")) {
					number.push(first + second);
				}
				if (tokens[i].equals("-")) {
					number.push(first - second);
				}
				if (tokens[i].equals("*")) {
					number.push(first * second);
				}
				if (tokens[i].equals("/")) {
					number.push(first / second);
				}
			} else {
				number.push(Integer.parseInt(tokens[i]));
			}
		}
		return number.pop();
	}

	public static void main(String[] args) {
		String[] A = { "4", "13", "5", "/", "+" };
		EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();

		System.out.println(erpn.evalRPN(A));

	}

}

import java.util.Stack;
import java.util.StringTokenizer;

public class BasicCalculatorII {

	public int calculate(String s) {
		StringTokenizer tokens = new StringTokenizer("+" + s.replace(" ", "") + "+0", "+-*/", true);
		long total = 0, term = 0;
		while (tokens.hasMoreTokens()) {
			String op = tokens.nextToken();
			if ("+-".contains(op)) {
				total += term;
				term = (op.equals("+") ? 1 : -1) * Long.parseLong(tokens.nextToken());
			} else {
				long n = Long.parseLong(tokens.nextToken());
				if (op.equals("*")) {
					term *= n;
				} else {
					term /= n;
				}
			}
		}
		return (int) total;
	}

	public int calculate1(String s) {
		int total = 0;
		for (String t : s.replace(" ", "").split("(?=[+-])")) {
			System.out.println(t);
			int term = 1;
			for (String u : ('*' + t).split("(?=[*/])")) {
				System.out.println(u);
				int n = Integer.parseInt(u.substring(1));
				term = u.startsWith("*") ? term * n : term / n;
			}
			total += term;
		}
		return total;
	}

	public int calculate2(String s) {
		s = s.trim();
		Stack<Integer> ns = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == ' ')
				continue;
			else if (cur >= '0' && cur <= '9') {
				num = num * 10 + cur - '0';
			}
			if (cur < '0' || cur > '9' || i == s.length() - 1) {
				if (sign == '+') {
					ns.push(num);
				}
				if (sign == '-') {
					ns.push(-num);
				}
				if (sign == '*') {
					ns.push(ns.pop() * num);
				}
				if (sign == '/') {
					ns.push(ns.pop() / num);
				}
				num = 0;
				sign = s.charAt(i);
			}

		}
		int result = 0;
		for (int n : ns) {
			result += n;
		}
		return result;
	}

	public int calculate3(String s) {
		s = s.trim();
		Stack<Integer> ns = new Stack<Integer>();
		Stack<Character> cs = new Stack<Character>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char cur = s.charAt(i);
			if (cur == ' ')
				continue;
			else if (cur == '+' || cur == '-') {
				while (!cs.isEmpty() && (cs.peek() == '*' || cs.peek() == '/')) {
					cal(ns, cs);
				}
				cs.push(cur);
			} else if (cur == '*' || cur == '/') {
				cs.push(cur);
			} else {
				String num = "";
				while (i >= 0 && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					num = s.charAt(i) + num;
					i--;
				}
				i++;
				ns.push(Integer.parseInt(num));
			}

		}
		while (!cs.isEmpty()) {
			cal(ns, cs);
		}
		return ns.pop();
	}

	public void cal(Stack<Integer> ns, Stack<Character> cs) {
		char op = cs.pop();
		int num1 = ns.pop();
		int num2 = ns.pop();
		if (op == '+')
			ns.push(num1 + num2);
		if (op == '-')
			ns.push(num1 - num2);
		if (op == '*')
			ns.push(num1 * num2);
		if (op == '/')
			ns.push(num1 / num2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculatorII bc = new BasicCalculatorII();
		System.out.println(bc.calculate1("1+2*1"));
	}

}

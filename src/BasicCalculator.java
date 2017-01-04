import java.util.Stack;

public class BasicCalculator {

	public int calculate(String s) {
		/*s = s.trim();
		if(s.length() == 0) return 0;
		s = "(" + s + ")";
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Character> stack2 = new Stack<Character>();
		int count = 0;
		while(count < s.length())
		{
			int currentNum = 0;
			while(count<s.length()&&s.charAt(count)>='0'&&s.charAt(count)<='9')
			{
				currentNum = currentNum*10 + s.charAt(count)-'0';
				count ++ ;
				if(currentNum == 0)
				{
					//System.out.println(count);
					stack1.push(0);
				}
			}
			if(currentNum != 0)
			{
				stack1.push(currentNum);
			}
			else if(s.charAt(count)==' ')
			{
				count ++ ;
			}
			else if(s.charAt(count)=='('||s.charAt(count)=='+'||s.charAt(count)=='-')
			{
				stack2.push(s.charAt(count));
				count ++;
			}
			else if(s.charAt(count)==')')
			{
				char fuhao = stack2.peek();
				//System.out.println(fuhao);
				if(fuhao=='(')
				{
					stack2.pop();
					count ++ ;
					continue;
				}
				
				while(stack2.peek() != '(')
				{
					fuhao = stack2.pop();
					
					int n1 = stack1.pop();
					int n2 = stack1.pop();
					if(fuhao=='-')
					{
						stack1.push(n2-n1);
					}
					if(fuhao=='+')
					{
						stack1.push(n2+n1);
					}
				}
				stack2.pop();
				count ++;
			}
		}
		if(stack1.isEmpty()) return 0;
		return stack1.peek();*/
		int n = s.length();
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Character> s2 = new Stack<Character>();
		String v = "";
		for(int i=n-1;i>=0;i--)
		{
			if(s.charAt(i)==')'||s.charAt(i)=='+'||s.charAt(i)=='-')
			{
				s2.push(s.charAt(i));
			}
			else if(s.charAt(i)>='0'&&s.charAt(i)<='9')
			{
				v = s.charAt(i) + v;
				if(i==0 || s.charAt(i-1)<'0'||s.charAt(i-1)>'9')
				{
					s1.push(Integer.parseInt(v));
					v = "";
				}
			}
			else if(s.charAt(i)=='(')
			{
				while(s2.peek() != ')')
				{
					cal(s1,s2);
				}
				s2.pop();
			}
		}
		while(!s2.isEmpty())
		{
			cal(s1,s2);
		}
		return s1.peek();
	}
	void cal(Stack<Integer> s1,Stack<Character> s2)
	{
		int v1 = s1.pop();
		int v2 = s1.pop();
		char c = s2.pop();
		if(c == '+') s1.push(v1 + v2);
		if(c == '-') s1.push(v1 - v2);
	}
	public int calculate2(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                number = number*10+c-'0';
            }
            else if(c=='+')
            {
                result += sign*number;
                number = 0;
                sign = 1;
            }
            else if(c=='-')
            {
                result += sign*number;
                number = 0;
                sign = -1;
            }
            else if(c=='(')
            {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(c==')')
            {
                result += sign*number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if(number!=0) result += sign*number;
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculator bc = new BasicCalculator();
		System.out.println(bc.calculate("(1)"));
	}

}

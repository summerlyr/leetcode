/*Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
answer:�ַ���ת�����ַ�ʱ��Long��װ���Զ���ȥ��ǰ������0

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
answer��java��integer��32λ�ġ���Χ��-2147483648��2147483648 ��Long�Ͱ�װ��Ȼ����ת����int
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

public class ReverseInteger {
	public int reverse(int x) {
		Integer xx = new Integer(x);
		String xs = xx.toString();
		String ys = new String();
		int end = 0;
		if (xx < 0) {
			xs += "-";
			end = xs.length() - 1;
		} else {
			end = xs.length();
		}
		for (int i = 0; i < end; i++) {
			ys += xs.substring(xs.length() - i - 1, xs.length() - i);
		}
		long y = Long.parseLong(ys);
		if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
			y = 0;
		}
		return (int) y;
	}

	public int reverse2(int x) {
		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x = x / 10;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		return (int) result;
	}

	public int reverse3(int x) {
		int result = 0;
		while (x != 0) {
			int newresult = result * 10 + x % 10;
			if ((newresult - x % 10) / 10 != result)
				return 0;
			result = newresult;
			x = x / 10;
		}
		return result;
	}
}

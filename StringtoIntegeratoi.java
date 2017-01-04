public class StringtoIntegeratoi {

	public int myAtoi(String str) {
		str = str.trim();
		int count = 0;
		int sign = 1;
		if (count < str.length() && (str.charAt(count) == '-' || str.charAt(count) == '+')) {
			if (str.charAt(count) == '-')
				sign = -1;
			count++;
		}
		int result = 0;
		for (int i = count; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
				break;
			int cur = str.charAt(i) - '0';
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && cur > Integer.MAX_VALUE % 10)) {
				return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + cur;
		}
		return sign * result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringtoIntegeratoi si = new StringtoIntegeratoi();
		System.out.println(si.myAtoi("2147483648"));
	}

}

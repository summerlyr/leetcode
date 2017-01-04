
public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int[] result = new int[len1 + len2];
		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {
				int index = len1 + len2 - i - j - 2;
				result[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				result[index + 1] += result[index] / 10;
				result[index] %= 10;
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = result.length - 1; i > 0; i--) {
			if (res.length() == 0 && result[i] == 0)
				continue;
			res.append(result[i]);
		}
		res.append(result[0]);
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

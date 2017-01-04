
public class AdditiveNumber {

	public boolean isAdditiveNumber(String num) {
		if (num.length() <= 2)
			return false;
		for (int i = 1; i <= num.length() / 2; i++) {
			if (num.charAt(0) == '0' && i > 1)
				break;
			Long x1 = Long.parseLong(num.substring(0, i));
			for (int j = 1; num.length() - i - j >= Math.max(i, j); j++) {
				if (num.charAt(i) == '0' && j > 1)
					break;
				Long x2 = Long.parseLong(num.substring(i, i + j));
				if (isValid(x1, x2, i + j, num))
					return true;
			}
		}
		return false;
	}

	public boolean isValid(Long x1, Long x2, int start, String num) {
		if (start == num.length())
			return true;
		x2 = x2 + x1;
		x1 = x2 - x1;
		return num.startsWith(x2.toString(), start) && isValid(x1, x2, start + x2.toString().length(), num);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

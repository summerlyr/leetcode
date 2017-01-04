public class AddBinary {

	public String addBinary(String a, String b) {
		if (a.length() == 0)
			return b;
		if (b.length() == 0)
			return a;
		int counta = a.length() - 1;
		int countb = b.length() - 1;
		int carry = 0;
		String result = "";
		while (counta >= 0 && countb >= 0) {
			int an = a.charAt(counta) - '0';
			int bn = b.charAt(countb) - '0';
			result = (an + bn + carry) % 2 + result;
			carry = (an + bn + carry) / 2;
			counta--;
			countb--;
		}
		while (counta >= 0) {
			int an = a.charAt(counta) - '0';
			result = (an + carry) % 2 + result;
			carry = (an + carry) / 2;
			counta--;
		}
		while (countb >= 0) {
			int bn = b.charAt(countb) - '0';
			result = (bn + carry) % 2 + result;
			carry = (bn + carry) / 2;
			countb--;
		}
		if (carry > 0)
			result = carry + result;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

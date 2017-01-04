
public class ReverseString {

	public String reverseString(String s) {
		char[] ca = s.toCharArray();
		int st = 0;
		int e = ca.length - 1;
		while (st < e) {
			char tmp = ca[st];
			ca[st] = ca[e];
			ca[e] = tmp;
			st++;
			e--;
		}
		return new String(ca);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

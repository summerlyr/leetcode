
public class ImplementstrStr {

	public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		if (haystack.length() == 0 && needle.length() != 0)
			return -1;
		if (haystack.length() < needle.length())
			return -1;

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			// System.out.println(haystack.substring(i, i + needle.length()));
			if (haystack.substring(i, i + needle.length()).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	public int strStr2(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		int length1 = haystack.length();
		int length2 = needle.length();
		for (int i = 0; i <= length1 - length2; i++) {
			String sub = haystack.substring(i, i + length2);
			if (sub.equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementstrStr is = new ImplementstrStr();
		System.out.println(is.strStr("a", "a"));
	}

}

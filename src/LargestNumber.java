import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public String largestNumber(int[] num) {
		if (num.length == 0)
			return "";
		String[] str = new String[num.length];
		for (int i = 0; i < num.length; i++) {
			str[i] = String.valueOf(num[i]);
		}
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;

				return s1.compareTo(s2);
			}
		};
		Arrays.sort(str, cmp);
		StringBuffer result = new StringBuffer();
		for (int i = str.length - 1; i >= 0; i--) {
			result.append(str[i]);
		}
		int i = 0;
		for (i = 0; i < result.length() && result.charAt(i) == '0'; i++)
			;
		if (i == result.length())
			return "0";

		return result.substring(i);
	}
}

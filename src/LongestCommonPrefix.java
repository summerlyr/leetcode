import java.util.Arrays;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		int minlen = Integer.MAX_VALUE;
		String minstr = "";
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < minlen) {
				minlen = strs[i].length();
			}
		}
		for (int i = 0; i < minlen; i++) {
			char cur = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) != cur) {
					return minstr;
				}
			}
			minstr = minstr + cur;
		}
		return minstr;
	}

	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0)
			return "";
		Arrays.sort(strs);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < strs[0].length(); i++) {
			char a = strs[0].charAt(i);
			char b = strs[strs.length - 1].charAt(i);
			if (a != b) {
				return result.toString();
			}
			result.append(a);
		}
		return result.toString();
	}

	public String longestCommonPrefix3(String[] strs) {
		if (strs.length == 0)
			return "";
		String pre = strs[0];
		int i = 1;
		while (i < strs.length) {
			while (strs[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length() - 1);
			}
			i++;
		}
		return pre;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs = { "c", "c" };
		System.out.println(lcp.longestCommonPrefix(strs));
	}

}

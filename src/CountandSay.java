public class CountandSay {

	public String countAndSay(int n) {
		StringBuilder result = new StringBuilder("1");
		StringBuilder pre;
		int count = 1;
		char cur = result.charAt(0);

		for (int i = 1; i < n; i++) {
			pre = result;
			result = new StringBuilder();
			count = 1;
			cur = pre.charAt(0);

			for (int j = 1, len = pre.length(); j < len; j++) {
				if (pre.charAt(j) != cur) {
					result.append(count).append(cur);
					count = 1;
					cur = pre.charAt(j);
				} else {
					count++;
				}
			}
			result.append(count).append(cur);

		}
		return result.toString();

	}

	public String countAndSay2(int n) {
		StringBuilder res = new StringBuilder("1");
		StringBuilder pre = new StringBuilder();
		if (n == 1)
			return res.toString();
		for (int i = 1; i < n; i++) {
			pre = res;
			res = new StringBuilder();
			int j = 0;
			while (j < pre.length()) {
				int count = 0;
				char cur = pre.charAt(j);
				while (j < pre.length() && pre.charAt(j) == cur) {
					j++;
					count++;
				}
				res.append(count).append(cur);
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountandSay ca = new CountandSay();
		System.out.println(ca.countAndSay(6));

	}

}

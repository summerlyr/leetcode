import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new LinkedList<String>();
		if (s.length() < 4)
			return result;
		help(result, "", s, 1);
		return result;
	}

	public void help(List<String> result, String current, String remain, int round) {
		if (round == 4 && remain.length() > 0) {
			if ((remain.length() == 1 && Integer.parseInt(remain) >= 0 && Integer.parseInt(remain) <= 9)
					|| (remain.length() == 2 && Integer.parseInt(remain) >= 10 && Integer.parseInt(remain) <= 99)
					|| (remain.length() == 3 && Integer.parseInt(remain) >= 100 && Integer.parseInt(remain) <= 255)) {
				current += "." + remain;
				result.add(current);
				return;
			}

		}
		if (round < 4) {
			for (int i = 0; i < 3; i++) {
				int r = round;
				if (remain.length() < i + 1)
					break;
				String c = remain.substring(0, i + 1);
				// System.out.println(c);
				if ((i == 0 && Integer.parseInt(c) >= 0 && Integer.parseInt(c) <= 9)
						|| (i == 1 && Integer.parseInt(c) >= 10 && Integer.parseInt(c) <= 99)
						|| (i == 2 && Integer.parseInt(c) >= 100 && Integer.parseInt(c) <= 255)) {
					String tmp = "";
					if (r == 1) {
						tmp = current + c;
					} else {
						tmp = current + "." + c;
					}

					help(result, tmp, remain.substring(i + 1), ++r);
				}
			}
		}
		return;
	}

	public List<String> restoreIpAddresses2(String s) {
		List<String> res = new LinkedList<String>();
		if (s.length() < 4 || s.length() > 12)
			return res;
		help(s, res, "", 0, 1);
		return res;
	}

	public void help(String s, List<String> res, String cur, int start, int round) {
		if (round > 4)
			return;
		if (start == s.length() && round == 4)
			res.add(cur);
		for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
			String part = s.substring(start, start + i);
			if ((i == 2 && Integer.parseInt(part) < 10)
					|| (i == 3 && (Integer.parseInt(part) < 100 || Integer.parseInt(part) > 255)))
				continue;
			help(s, res, cur + part + ".", start + i, round + 1);
		}
	}

	public List<String> restoreIpAddresses3(String s) {
		List<String> res = new LinkedList<String>();
		if (s.length() < 4 || s.length() > 12)
			return res;
		for (int i = 1; i <= 3; i++) {
			if (s.length() - i > 9)
				continue;
			for (int j = i + 1; j <= i + 3; j++) {
				if (s.length() - j > 6)
					continue;
				for (int k = j + 1; k <= j + 3 && k < s.length(); k++) {
					if (s.length() - k > 3)
						continue;
					int a = Integer.parseInt(s.substring(0, i));
					int b = Integer.parseInt(s.substring(i, j));
					int c = Integer.parseInt(s.substring(j, k));
					int d = Integer.parseInt(s.substring(k));
					String cur = "";
					if (a <= 255 && b <= 255 && c <= 255 && d <= 255)
						cur = a + "." + b + "." + c + "." + d;
					if (cur.length() < s.length() + 3)
						continue;
					res.add(cur);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses ra = new RestoreIPAddresses();
		System.out.println(ra.restoreIpAddresses2("1111"));
	}

}

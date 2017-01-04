import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {

	/*
	 * public List<List<String>> partition(String s) { List<List<String>> result
	 * = new ArrayList<List<String>>(); if(s.length() == 0) { return result; }
	 * if(s.length() == 1) { List<String> list = new ArrayList<String>();
	 * list.add(s); result.add(list); return result; } for(int
	 * i=0;i<s.length();i++) {
	 * 
	 * String cur = s.substring(0, i+1); List<List<String>> tmp = new
	 * ArrayList<List<String>>(); if(isPalindrome(cur)) { tmp =
	 * partition(s.substring(i+1)); if(tmp.size()==0) { List<String> current =
	 * new ArrayList<String>(); current.add(cur); result.add(current); } for(int
	 * j=0;j<tmp.size();j++) { List<String> current = new ArrayList<String>();
	 * current.add(cur); current.addAll(tmp.get(j)); result.add(current); } }
	 * 
	 * }
	 * 
	 * return result; } public boolean isPalindrome(String s) { int length =
	 * s.length(); int start = 0,end = length - 1; while(end > start) { char
	 * startchar = s.charAt(start++); char endchar = s.charAt(end--);
	 * if(startchar != endchar) { return false; } } return true; }
	 */
	List<List<String>> result = new ArrayList<List<String>>();

	public List<List<String>> partition(String s) {
		helper(s, new ArrayList<String>());
		return result;
	}

	public void helper(String s, List<String> cur) { // DFS every combinations
		if (s.length() == 0) {
			result.add(cur);
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String sub = s.substring(0, i);
			if (isPal(sub)) {
				List<String> newList = new ArrayList<String>(cur);
				System.out.println(newList);
				newList.add(sub);
				helper(s.substring(i, s.length()), newList);
			} else
				continue; // not palindrome, ignore it
		}
	}

	public boolean isPal(String str) {
		int l = 0;
		int r = str.length() - 1;
		while (l <= r) {
			if (str.charAt(l) != str.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

	public List<List<String>> partition2(String s) {
		List<List<String>> res = new LinkedList<List<String>>();
		if (s.length() == 0)
			return res;
		help(s, res, new LinkedList<String>(), 0);
		return res;
	}

	public void help(String s, List<List<String>> res, List<String> cur, int start) {
		if (start == s.length()) {
			List<String> list = new LinkedList<String>();
			for (String t : cur)
				list.add(t);
			res.add(list);
			return;
		}
		for (int i = start + 1; i <= s.length(); i++) {
			if (isPal(s.substring(start, i))) {
				cur.add(s.substring(start, i));
				help(s, res, cur, i);
				cur.remove(cur.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("aab"));

	}

}

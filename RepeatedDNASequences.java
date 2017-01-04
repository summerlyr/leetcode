import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
	private static final Map<Character, Integer> A = new HashMap<Character, Integer>();

	static {
		A.put('A', 0);
		A.put('C', 1);
		A.put('G', 2);
		A.put('T', 3);
	}

	private final int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);

	public List<String> findRepeatedDnaSequences1(String s) {
		Set<String> res = new HashSet<String>();
		Set<Integer> hashes = new HashSet<Integer>();
		for (int i = 0, rhash = 0; i < s.length(); i++) {
			if (i > 9)
				rhash -= A_SIZE_POW_9 * A.get(s.charAt(i - 10));
			rhash = A.size() * rhash + A.get(s.charAt(i));
			if (i > 8 && !hashes.add(rhash))
				res.add(s.substring(i - 9, i + 1));
		}
		return new ArrayList<String>(res);
	}

	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> list = new HashSet<String>();
		Set<Integer> set = new HashSet<Integer>();
		if (s.length() < 10)
			return new ArrayList<String>(list);
		int result = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		int mi = (int) Math.pow(map.size(), 9);
		for (int i = 0; i < 10; i++) {
			result = result * 4 + map.get(s.charAt(i));
		}
		set.add(result);
		for (int i = 10; i < s.length(); i++) {
			result = result - mi * map.get(s.charAt(i - 10));// ��ȥ���λ
			result = result * 4 + map.get(s.charAt(i));// ������λ�ټ��������λ
			if (!set.add(result)) {
				list.add(s.substring(i - 9, i + 1));
			}
		}
		return new ArrayList<String>(list);

	}

	public List<String> findRepeatedDnaSequences2(String s) {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		for (int i = 0; i < s.length() - 9; i++) {
			String cur = s.substring(i, i + 10);
			if (set1.contains(cur)) {
				set2.add(cur);
			} else {
				set1.add(cur);
			}
		}
		return new LinkedList<String>(set2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedDNASequences rs = new RepeatedDNASequences();
		System.out.println(rs.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> res = new FindAllAnagramsinaString().findAnagrams("baa", "aa");
		for(int n:res) {
			System.out.println(n);
		}
	}

	//force
	public List<Integer> findAnagrams(String s, String p) {

		char[] ca = p.toCharArray();

		List<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<s.length();i++) {
			Map<Character,Integer> map = new HashMap<Character,Integer>();
			for(char c:ca) {
				if(map.containsKey(c)) {
					map.put(c, map.get(c)+1);
				}
				else map.put(c, 1);
			}
			int start = i;
			int index = i;
			while(index<s.length()) {
				if(map.containsKey(s.charAt(index))) {
					map.put(s.charAt(index), map.get(s.charAt(index))-1);
					if(map.get(s.charAt(index))==0) map.remove(s.charAt(index));
					index++;
					if(map.size()==0) list.add(start);
				}
				else break;
			}
			
		}
		return list;
	}
	//O（N）
	public List<Integer> findAnagrams2(String s, String p) {
		if(s.length()==0||p.length()==0||s.length()<p.length()) return new LinkedList<Integer>();
		
		List<Integer> res = new LinkedList<Integer>();
		int[] sa = new int[256];
		int[] pa = new int[256];
		for(int i=0;i<p.length();i++) {
			sa[s.charAt(i)]++;
		}
		for(int i=0;i<p.length();i++) {
			pa[p.charAt(i)]++;
		}
		
		for(int i=0;i<s.length();i++) {
			if(judege(sa,pa)) {
				res.add(i);
			}
			if(i+p.length()<s.length()) {
				sa[s.charAt(i)]--;
				sa[s.charAt(i+p.length())]++;
			}
			else break;
			
		}
		return res;
	}

	private boolean judege(int[] sa, int[] pa) {
		// TODO Auto-generated method stub
		for(int i=0;i<sa.length;i++) {
			if(sa[i]!=pa[i]) return false;
		}
		return true;
	}

}

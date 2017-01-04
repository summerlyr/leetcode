import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString {

	public String reverseVowels(String s) {
		Set<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		int l = 0;
		int h = s.length() - 1;
		char[] ca = s.toCharArray();
		while (l < h) {
			while (l < h && !set.contains(ca[l]))
				l++;
			while (l < h && !set.contains(ca[h]))
				h--;
			char tmp = ca[l];
			ca[l] = ca[h];
			ca[h] = tmp;
			l++;
			h--;
		}
		return new String(ca);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

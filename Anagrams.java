import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Anagrams {

	public ArrayList<String> anagrams(String[] strs) {
		HashMap<String, HashSet<String>> anagramGroups = new HashMap<String, HashSet<String>>();

		for (String s : strs) {
			String sig = getSignature(s);
			if (anagramGroups.containsKey(sig)) {
				HashSet<String> group = anagramGroups.get(sig);
				if (!group.contains(s)) {
					group.add(s);
				}
			} else {
				HashSet<String> newGroup = new HashSet<String>();
				newGroup.add(s);
				anagramGroups.put(sig, newGroup);
			}
		}

		// Flatten the groups.
		ArrayList<String> output = new ArrayList<String>();
		for (Map.Entry<String, HashSet<String>> group : anagramGroups.entrySet()) {
			output.addAll(group.getValue());
		}

		return output;
	}

	private String getSignature(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams ag = new Anagrams();
		String[] strs = { "a", "a" };
		System.out.println(ag.anagrams(strs));
	}

}

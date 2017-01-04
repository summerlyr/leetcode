import java.util.HashMap;
import java.util.Map;

public class BullsandCows {
	public String getHint(String secret, String guess) {
		int n = secret.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int counta = 0;
		int countb = 0;
		for (int i = 0; i < n; i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				counta++;
			} else {
				if (map.containsKey(secret.charAt(i))) {
					map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
				} else {
					map.put(secret.charAt(i), 1);
				}

			}
		}
		for (int i = 0; i < n; i++) {
			if (secret.charAt(i) != guess.charAt(i) && map.containsKey(guess.charAt(i))) {
				if (map.get(guess.charAt(i)) > 0) {
					countb++;
					map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
				}
			}
		}
		return counta + "A" + countb + "B";
	}

	public String getHint2(String secret, String guess) {
		int n = secret.length();
		int[] first = new int[10];
		int[] second = new int[10];
		int counta = 0;
		int countb = 0;
		for (int i = 0; i < n; i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				counta++;
			} else {
				first[secret.charAt(i) - '0']++;
				second[guess.charAt(i) - '0']++;
			}
		}
		for (int i = 0; i <= 9; i++) {
			countb += Math.min(first[i], second[i]);
		}
		return counta + "A" + countb + "B";
	}

	public String getHint3(String secret, String guess) {
		int n = secret.length();
		int[] map = new int[10];
		int counta = 0;
		int countb = 0;
		for (int i = 0; i < n; i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				counta++;
			} else {
				if (map[secret.charAt(i) - '0']++ < 0)
					countb++;
				if (map[guess.charAt(i) - '0']-- > 0)
					countb++;
			}
		}
		return counta + "A" + countb + "B";
	}

	public String getHint4(String secret, String guess) {
		int n = secret.length();
		int[] map = new int[10];
		int counta = 0;
		int countb = 0;
		for (int i = 0; i < n; i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				counta++;
			} else {
				map[secret.charAt(i) - '0']++;
			}
		}
		for (int i = 0; i < n; i++) {
			if (secret.charAt(i) != guess.charAt(i)) {
				if (map[guess.charAt(i) - '0'] > 0) {
					countb++;
					map[guess.charAt(i) - '0']--;
				}
			}
		}
		return counta + "A" + countb + "B";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

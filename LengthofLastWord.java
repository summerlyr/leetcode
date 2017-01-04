
public class LengthofLastWord {

	public int lengthOfLastWord(String s) {

		String[] list = s.split("\\s");
		if (list.length == 0) {
			return 0;
		}
		int i = 0;
		for (i = list.length - 1; i > 0; i--) {
			if (list[i].length() != 0) {
				break;
			}
		}
		System.out.println(i);

		return list[i].length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthofLastWord llw = new LengthofLastWord();
		System.out.println(llw.lengthOfLastWord("hello world    "));
	}

}

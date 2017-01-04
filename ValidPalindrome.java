
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		String tmp = "";
		/*
		 * for(int i=0;i<s.length();i++) { if((s.charAt(i)>='a' && s.charAt(i)
		 * <= 'z')||(s.charAt(i)>='0' && s.charAt(i)<='9')) { tmp +=
		 * s.substring(i,i+1); } }
		 */
		// ������ע�͵��Ĵ�����ʾTLE����֪��Ϊɶ����
		tmp = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();// ������ʽ^��ʾ�ǣ����������ʽ���ǳ���a-zA-Z0-9���ַ����滻�ɿ��ַ�
		// System.out.println(tmp);
		int length = tmp.length();
		int start = 0, end = length - 1;
		while (end > start) {
			char startchar = tmp.charAt(start++);
			char endchar = tmp.charAt(end--);
			// System.out.println(start +" "+startchar+"*"+end + " " +endchar);
			if (startchar != endchar) {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindrome2(String s) {
		s = s.toLowerCase();
		char[] ca = s.toCharArray();
		int start = 0;
		int end = ca.length - 1;
		while (start <= end) {
			while ((start < end)
					&& !((ca[start] >= 'a' && ca[start] <= 'z') || (ca[start] >= '0' && ca[start] <= '9'))) {
				start++;
			}
			while ((start < end) && !(ca[end] >= 'a' && ca[end] <= 'z' || (ca[end] >= '0' && ca[end] <= '9'))) {
				end--;
			}
			if (ca[start] == ca[end]) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		boolean b = vp.isPalindrome("race a car");
		System.out.println(b);
	}

}

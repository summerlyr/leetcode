
public class CompareVersionNumbers {

	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int length = v1.length >= v2.length ? v1.length : v2.length;

		for (int i = 0; i < length; i++) {
			int vv1 = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
			int vv2 = i >= v2.length ? 0 : Integer.parseInt(v2[i]);
			if (vv1 > vv2) {
				return 1;
			}
			if (vv1 < vv2) {
				return -1;
			}
		}
		return 0;
	}

	public int compareVersion2(String version1, String version2) {
		int len1 = version1.length();
		int len2 = version2.length();
		int i = 0;
		int j = 0;
		while (i < len1 || j < len2) {
			int tmp1 = 0;
			int tmp2 = 0;
			while (i < len1 && version1.charAt(i) != '.') {
				tmp1 = tmp1 * 10 + (version1.charAt(i++) - '0');
			}
			while (j < len2 && version2.charAt(j) != '.') {
				tmp2 = tmp2 * 10 + (version2.charAt(j++) - '0');
			}
			if (tmp1 > tmp2)
				return 1;
			if (tmp1 < tmp2)
				return -1;
			i++;
			j++;
		}
		return 0;
	}

	public static void main(String[] args) {
		CompareVersionNumbers cvn = new CompareVersionNumbers();
		System.out.println(cvn.compareVersion("1.0", "1"));

	}

}

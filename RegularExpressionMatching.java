
public class RegularExpressionMatching {

	/**
     * f[i][j]: if s[0..i-1] matches p[0..j-1]
     * if p[j - 1] != '*'
     *      f[i][j] = f[i - 1][j - 1] && s[i - 1] == p[j - 1]
     * if p[j - 1] == '*', denote p[j - 2] with x
     *      f[i][j] is true iff any of the following is true
     *      1) "x*" repeats 0 time and matches empty: f[i][j - 2]
     *      2) "x*" repeats >= 1 times and matches "x*x": s[i - 1] == x && f[i - 1][j]
     * '.' matches any single character
     */
	public boolean isMatch(String s, String p) {
        int m = s.length();
		int n = p.length();
		boolean[][] res = new boolean[m+1][n+1];
		
		res[0][0] = true;
		for(int i=1;i<=m;i++)
		{
			res[i][0] = false;
		}
		for(int i=1;i<=n;i++)
		{
			res[0][i] = i>1&&(p.charAt(i-1)=='*')&&res[0][i-2];
		}
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(p.charAt(j-1)!='*')
				{
					res[i][j] = res[i-1][j-1]&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.');
				}
				else
				{
					res[i][j] = res[i][j-2]||(res[i-1][j]&&(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.'));
				}
			}
		}
		return res[m][n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

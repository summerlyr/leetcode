
public class NumberofDigitOne {
	public int countDigitOne(int n) {
        int count = 0;
        for(long m = 1;m<=n;m=m*10) {
            long r = n/m;
            long s = n%m;
            count += (r+8)/10*m+(r%10==1?s+1:0);
        }
        return count;
    }
}

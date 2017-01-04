
public class ArrangingCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new ArrangingCoins().arrangeCoins(1804289383));
	}
	
	public int arrangeCoins(int n) {
        if(n==0) return 0;
        long left = 1;
        long right = n;
        
        while(left<right) {
            long mid = (left+right)/2;
            long cur = mid*(mid+1)/2;
            if(cur>n) {
                right = mid-1;
            }
            else if(n-cur<mid+1) {
                return (int)mid;
            }
            else left = mid+1;
        }
        return (int)left;
    }

}

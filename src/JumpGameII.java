
public class JumpGameII {

	public int jump2(int[] A) {
		int maxReach = A[0];
		int edge = 0;
		int minstep = 0;

		for (int i = 1; i < A.length; i++) {
			if (i > edge) {
				minstep += 1;
				edge = maxReach;
				if (edge > A.length - 1)
					return minstep;
			}
			maxReach = Math.max(maxReach, A[i] + i);
			if (maxReach == i)
				return -1;
		}

		return minstep;
	}

	public int jump(int[] nums) {
        if(nums==null|nums.length==0) return -1;
        if(nums.length==1) return 0;
        int maxreach = 0;
        int step = 0;
        int edge = 0;
        for(int i=0;i<nums.length;i++) {
            if(i>edge) {
                step++;
                edge = maxreach;
                if(maxreach>=nums.length-1) return step;
            }
            if(nums[i]==0&&maxreach==i) return -1;
            maxreach = Math.max(maxreach,i+nums[i]);
        }
        return step;
    }

	public static void main(String[] args) {
		JumpGameII jg = new JumpGameII();
		int[] a = { 1, 2, 3 };
		System.out.println(jg.jump(a));
	}

}

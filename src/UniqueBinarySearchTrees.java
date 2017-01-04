public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		int[] result = new int[n+1];
		result[0] = 1;
		result[1] = 1;
		
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{										   //注意是二叉搜索树！！累加的意思是在1-n中，1-n都有可能是根节点，对每一个数字当根节点，都有如下解释：
				result[i] += result[j-1] * result[i-j];//在二叉搜索树中，当i为根节点时，有i-1个节点比他小，
													   //有j-i个节点比他大，所以相乘就是最终结果
			}
		}
		return result[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTrees ubs = new UniqueBinarySearchTrees();
		System.out.println(ubs.numTrees(3));
	}

}

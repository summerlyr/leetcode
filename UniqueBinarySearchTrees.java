public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		int[] result = new int[n+1];
		result[0] = 1;
		result[1] = 1;
		
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{										   //ע���Ƕ��������������ۼӵ���˼����1-n�У�1-n���п����Ǹ��ڵ㣬��ÿһ�����ֵ����ڵ㣬�������½��ͣ�
				result[i] += result[j-1] * result[i-j];//�ڶ����������У���iΪ���ڵ�ʱ����i-1���ڵ����С��
													   //��j-i���ڵ������������˾������ս��
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

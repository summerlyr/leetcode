
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q)// Ҫ��ס �ӵ�ǰ�ڵ���������
														// ��Ҫ����̫�����Һ��ӵ�����
														// �������̫��
	{
		if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}
		if (p == null && q == null) {
			return true;
		}
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

	public boolean isSameTree2(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		return false;
	}
}

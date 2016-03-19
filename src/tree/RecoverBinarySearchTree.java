package tree;
//Two elements of a binary search tree (BST) are swapped by mistake. Recover the tree without changing its structure.
//A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
import java.util.ArrayList;
public class RecoverBinarySearchTree {
	//O(n)�ռ�Ľⷨ�Ƚ�ֱ�ۣ��������һ���Ժ����¸�ֵһ�鼴�ɣ�����ⷨ��������n��Ԫ�ش�λ�������
	//O(1)�ռ�Ľⷨ,����ͨ�����������ֻ����������Ҫ�洢ÿ���ڵ㣬ֻ��Ҫ��һ��ǰ�����ɡ�
	public void recoverTree(TreeNode root) {
		if(root==null)
			return;
		InOrderTravel(root);
		swap(Treea, Treeb);
	}
	//ArrayList inorder=new ArrayList();
	TreeNode Treeprev, Treea, Treeb;
	public void InOrderTravel(TreeNode root){
		if(root==null)
			return;
		InOrderTravel(root.left);
		//inorder.add(root.val);
		if(Treeprev!=null && root.val<Treeprev.val){
			if(Treea==null)
				Treea=Treeprev;
			Treeb=root;
		}			
		Treeprev=root;
		InOrderTravel(root.right);
	}
	void swap(TreeNode Treea, TreeNode Treeb){
		int c=Treea.val;
		Treea.val=Treeb.val;
		Treeb.val=c;
	}

}

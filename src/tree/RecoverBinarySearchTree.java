package tree;
//Two elements of a binary search tree (BST) are swapped by mistake. Recover the tree without changing its structure.
//A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
import java.util.ArrayList;
public class RecoverBinarySearchTree {
	//O(n)空间的解法比较直观，中序遍历一遍以后，重新赋值一遍即可，这个解法可以面向n个元素错位的情况。
	//O(1)空间的解法,还是通过中序遍历，只不过，不需要存储每个节点，只需要存一个前驱即可。
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

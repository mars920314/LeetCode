package tree;
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//Find the total sum of all root-to-leaf numbers.
public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root){
		if(root==null)
			return 0;
		return addprev(root, 0);
	}
	int addprev(TreeNode root, int prev){
		if(root==null)
			return prev;
		int left=addprev(root.left, prev*10+root.val);
		int right=addprev(root.right, prev*10+root.val);
		if(root.left==null)
			return right;
		if(root.right==null)
			return left;
		return left+right;		
	}

}

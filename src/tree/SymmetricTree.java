package tree;
//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
public class SymmetricTree {
	//recursively
	public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		return checksym(root.left, root.right);
	}
	boolean checksym(TreeNode left, TreeNode right){
		if(left==null && right==null)
			return true;
		else if(left!=null && right!=null)
			if(left.val==right.val)
				return(checksym(left.left,right.right) && checksym(left.right, right.left));
			else
				return false;
		return false;
	}
	//iteratively 
	public boolean isSymmetric2(TreeNode root) {
		return true;
	}

}

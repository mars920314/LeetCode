package tree;
//Given a binary tree, determine if it is height-balanced. For this problem, a height-balanced binary tree is 
//defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
public class BalancedBinaryTree {
	boolean balanced=true;
	public boolean isBalanced(TreeNode root) {
		if(root==null)
			return balanced;
		inordertraversal(root);
		return balanced;
	}
	int inordertraversal(TreeNode root){
		if(root==null)
			return 0;
		int left=inordertraversal(root.left);
		int right=inordertraversal(root.right);
		int max=Math.max(left, right);
		int min=Math.min(left, right);
		if(max-min>1)
			balanced=false;
		return max+1;
	}

}

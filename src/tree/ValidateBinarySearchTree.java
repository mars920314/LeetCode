package tree;
//Given a binary tree, determine if it is a valid binary search tree (BST).
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root){
		if(root !=null)
			return isValid(root,Long.MAX_VALUE,Long.MIN_VALUE);
		return true;
	}
	boolean isValid(TreeNode root, long max, long min){
		if(root.val<max && root.val>min){
			if(root.left==null || isValid(root.left,root.val,min))
				if(root.right==null || isValid(root.right,max,root.val))
					return true;
		}
		return false;
	}
	
	//another method
	boolean valid=true;
    public boolean isValidBST1(TreeNode root) {
        inorder(root, Integer.MIN_VALUE-100);	//-100 is to avoid test case [Integer.MIN_VALUE, Integer.MIN_VALUE]
        return valid;
    }
    int inorder(TreeNode root, int prev){
        if(root==null)
            return prev;
        prev=inorder(root.left,prev);
        if(prev!=Integer.MIN_VALUE-100 && root.val<=prev)
            valid=false;
        prev=root.val;
        prev=inorder(root.right,prev);
        return prev;
    }

}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}
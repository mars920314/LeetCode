package tree;

public class MaximumDepthofBinaryTree {
	//Given a binary tree, find its maximum depth.
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=1;
        int right=1;
        if(root.left!=null)
            left=maxDepth(root.left)+1;
        if(root.right!=null)
            right=maxDepth(root.right)+1;
        return Math.max(left, right);
    }
    //Given a binary tree, find its minimum depth.
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        if(root.left!=null)
            left=minDepth(root.left)+1;
        if(root.right!=null)
            right=minDepth(root.right)+1;
        return Math.min(left, right);
    }

}

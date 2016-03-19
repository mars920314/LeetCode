package tree;
//Given a binary tree, find the maximum path sum.
public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if(root==null)
			return 0;
		//postordertraversal(root);
		postordertraversal1(root);
		return max;
	}
	int max=Integer.MIN_VALUE;
	int postordertraversal(TreeNode root){
		int sumleft=0;
		int sumright=0;
		if(root.left==null && root.right==null){
			max=Math.max(max, root.val);
			return root.val;
		}
		int maxpath=root.val;
		if(root.left!=null){
			sumleft=postordertraversal(root.left)+root.val;
			maxpath=Math.max(maxpath, sumleft);
		}
		if(root.right!=null){
			sumright=postordertraversal(root.right)+root.val;
			maxpath=Math.max(maxpath, sumright);
		}
		if(root.left!=null || root.right!=null)
			max=Math.max(max, Math.max(maxpath, sumleft+sumright-root.val));
		return maxpath;
	}
	//simplify postordertraversal
	int postordertraversal1(TreeNode root){
		if(root==null)
			return 0;
		int left=postordertraversal1(root.left);
		int right=postordertraversal1(root.right);
		int maxpath=Math.max(0, Math.max(left, right))+root.val;
		max=Math.max(max, Math.max(maxpath, left+right+root.val));
		return maxpath;
	}
	public static void main(String[] args){
		TreeNode treenode1=new TreeNode(-1);
		TreeNode treenode2=new TreeNode(0);
		TreeNode treenode3=new TreeNode(1);
		treenode1.left=treenode2;
		treenode1.right=treenode3;
		BinaryTreeMaximumPathSum BTMPS=new BinaryTreeMaximumPathSum();
		System.out.print(BTMPS.maxPathSum(treenode1));
	}

}

package devidedConquer;
//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0)
			return null;
		return convert(nums, 0, nums.length-1);
	}
	TreeNode convert(int[] nums, int start, int end){
		TreeNode root;
		if(start>end)
			return null;
		int mid=(start+end)/2;
		root=new TreeNode(nums[mid]);
		root.left=convert(nums, start, mid-1);
		root.right=convert(nums, mid+1, end);
		return root;
	}

}

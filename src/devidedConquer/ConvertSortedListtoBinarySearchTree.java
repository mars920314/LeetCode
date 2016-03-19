package devidedConquer;
//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
public class ConvertSortedListtoBinarySearchTree {
	ListNode currenthead = null;
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null)
			return null;
		currenthead=head;
		int len=0;
		while(head!=null){
			len++;
			head=head.next;
		}
		return sort(0, len-1);		
	}
	TreeNode sort(int start, int end){
		if(start>end)
			return null;
		int mid=(start+end)/2;
		TreeNode left=sort(start, mid-1);
		TreeNode root=new TreeNode(currenthead.val);
		currenthead=currenthead.next;
		root.left=left;
		root.right=sort(mid+1, end);
		return root;
	}
	//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
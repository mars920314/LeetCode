package DfsBfs;
//You may assume that duplicates do not exist in the tree.
import java.util.HashMap;
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	//Given preorder and inorder traversal of a tree, construct the binary tree.
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0 || inorder.length==0)
			return null;
		HashMap<Integer, Integer> inordermap=new HashMap<Integer, Integer>();
		for(int i=0;i<inorder.length;i++){
			inordermap.put(inorder[i], i);
		}
		TreeNode root=build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
		return root;
	}
	TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
		if(instart>inend)
			return null;
		TreeNode root=null;
		int i;
		for(i=instart; i<=inend; i++){
			if(inorder[i]==preorder[prestart]){
				root=new TreeNode(preorder[prestart]);
				break;
			}
		}
		root.left=build(preorder, prestart+1, prestart+i-instart, inorder, instart, i-1);
		root.right=build(preorder, prestart+i+1-instart, preend, inorder, i+1, inend);
		return root;
	}
	//Given inorder and postorder traversal of a tree, construct the binary tree.
	public TreeNode buildTree1(int[] inorder, int[] postorder) {
		if(inorder.length==0 || postorder.length==0)
			return null;
		TreeNode root=build1(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
		return root;
	}
	TreeNode build1(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
		if(instart>inend)
			return null;
		TreeNode root=null;
		int i;
		for(i=inend; i>=instart; i--){
			if(inorder[i]==postorder[postend]){
				root=new TreeNode(postorder[postend]);
				break;
			}
		}
		root.right=build1(inorder, i+1, inend, postorder, postend-(inend-i), postend-1);
		root.left=build1(inorder, instart, i-1, postorder, poststart, postend-(inend-i)-1);
		return root;
	}

}

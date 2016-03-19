package datastructure;

public class traversal {
	void inordertraversal(TreeNode root){
		if(root==null)
			return;
		inordertraversal(root.left);
		System.out.print(root.val);
		inordertraversal(root.right);
	}
	void preordertraversal(TreeNode root){
		if(root==null)
			return;
		System.out.print(root.val);
		inordertraversal(root.left);
		inordertraversal(root.right);
	}
	void postordertraversal(TreeNode root){
		if(root==null)
			return;
		inordertraversal(root.left);
		inordertraversal(root.right);
		System.out.print(root.val);
	}
	public static void main(String[] args){
		TreeNode tree1=new TreeNode(1);
		TreeNode tree2=new TreeNode(2);
		TreeNode tree3=new TreeNode(3);
		TreeNode tree4=new TreeNode(4);
		TreeNode tree5=new TreeNode(5);
		TreeNode tree6=new TreeNode(6);
		TreeNode tree7=new TreeNode(7);
		tree2.left=tree1;
		tree2.right=tree3;
		tree6.left=tree5;
		tree6.right=tree7;
		tree4.left=tree2;
		tree4.right=tree6;
		traversal Tra=new traversal();
		Tra.inordertraversal(tree4);
	}

}

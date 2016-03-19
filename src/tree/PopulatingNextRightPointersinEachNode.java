package tree;
//Given a binary tree, Populate each next pointer to point to its next right node. If there is no next right node, 
//the next pointer should be set to NULL. Initially, all next pointers are set to NULL.
public class PopulatingNextRightPointersinEachNode {
	//You may assume that it is a perfect binary tree 
	public void connect(TreeLinkNode root){
		if(root==null || root.left==null || root.right==null)
			return;
		root.left.next=root.right;
		if(root.next!=null)
			root.right.next=root.next.left;
		else
			root.right.next=null;
		connect(root.left);
		connect(root.right);
	}
	//What if the given tree could be any binary tree? 
	public void connect2(TreeLinkNode root){
		if(root==null)
			return;
		TreeLinkNode rootnext=root.next;
		while(rootnext!=null){
			if(rootnext.left!=null){
				rootnext=rootnext.left;
				break;
			}
			if(rootnext.right!=null){
				rootnext=rootnext.right;
				break;
			}
			rootnext=rootnext.next;
		}
		if(root.right!=null)
			root.right.next=rootnext;
		if(root.left!=null)
			if(root.right!=null)
				root.left.next=root.right;
			else
				root.left.next=rootnext;
		
		connect2(root.right);
		connect2(root.left);
		
	}

}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
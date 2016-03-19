package test;

public class subtree {
	public boolean issubtree(TreeNode tree1, TreeNode tree2){
		if(tree2==null)
			return true;
		else if(tree1==null)
			return false;
		else return isSameTree(tree1,tree2) || issubtree(tree1.left,tree2) || issubtree(tree1.right,tree2);
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        else if(p!=null && q!=null){
            return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else
            return false;
    }

}

package datastructure;

public class BinarySearchTree {
	TreeNode root=null;
	BinarySearchTree(int x){
		this.root=new TreeNode(x);
	}
	void insert(int x){
		insert_current(root, x);
	}
	TreeNode insert_current(TreeNode current, int x){
		if(current==null){
			return new TreeNode(x);
		}
		else if(x<current.val)
			current.left=insert_current(current.left, x);
		else if(x>current.val)
			current.right=insert_current(current.right, x);
		else
			;
		return current;
	}
	TreeNode search(int x){
		TreeNode tmp=root;
		while(tmp!=null){
			if(tmp.val==x)
				return tmp;
			else if(x<tmp.val)
				tmp=tmp.left;
			else
				tmp=tmp.right;
		}
		return null;		
	}
	void delete(int x){
		delete_current(root, x);
	}
	TreeNode delete_current(TreeNode current, int x){
		if(x<current.val)
			current.left=delete_current(current.left, x);
		else if(x>current.val)
			current.right=delete_current(current.right, x);
		else
			if(current.left!=null && current.right!=null){
				TreeNode tmp=current.right;
				while(tmp.left!=null)
					tmp=tmp.left;
				current.val=tmp.val;
				delete_current(current.right, tmp.val);
			}
			else if(current.left==null && current.right!=null)
				return current.right;
			else if(current.left!=null && current.right==null)
				return current.left;
			else
				return null;
		return current;
	}
	public static void main(String[] args){
		BinarySearchTree BST=new BinarySearchTree(10);
		BST.insert(5);
		BST.insert(8);
		BST.insert(3);
		BST.insert(7);
		BST.insert(6);
		BST.delete(5);
		TreeNode se=BST.search(1);
	}

}

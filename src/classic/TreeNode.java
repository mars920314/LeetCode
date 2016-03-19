package classic;

//binary tree
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int var){
		this.val=var;
	}
	private void clear(){
		val=0;
		left=null;
		right=null;
	}
	
	public static void main(String[] args){
		TreeNode treenode1=new TreeNode(1);
		TreeNode treenode2=new TreeNode(2);
		TreeNode treenode3=new TreeNode(3);
		TreeNode treenode4=new TreeNode(4);
		TreeNode treenode5=new TreeNode(5);
		TreeNode treenode6=new TreeNode(6);
		TreeNode treenode7=new TreeNode(7);
		treenode1.left=treenode2;
		treenode1.right=treenode3;
		treenode2.left=treenode4;
		treenode2.right=treenode5;
		treenode3.left=treenode6;
		treenode3.right=treenode7;
	}

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

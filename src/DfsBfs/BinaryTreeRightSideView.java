package DfsBfs;
//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		if(root==null)
			return list;
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0;i<size;i++){
				TreeNode front=queue.get(0);
				queue.remove(0);
				if(i==0)
					list.add(front.val);
				if(front.right!=null)
					queue.add(front.right);
				if(front.left!=null)
					queue.add(front.left);
			}
		}
		return list;
	}
	public static void main(String[] args){
		TreeNode treenode1=new TreeNode(1);
		TreeNode treenode2=new TreeNode(2);
		TreeNode treenode3=new TreeNode(2);
		treenode1.left=treenode2;
		treenode1.right=treenode3;
		BinaryTreeRightSideView BTRSV=new BinaryTreeRightSideView();
		System.out.print(BTRSV.rightSideView(treenode1));
	}
}

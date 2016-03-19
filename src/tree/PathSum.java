package tree;
//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
import java.util.ArrayList;
import java.util.List;

public class PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		if(root!=null)
			preordertraversal(root, sum, array, list);
		return list;
	}
	void preordertraversal(TreeNode root, int sum, ArrayList<Integer> array, List<List<Integer>> list){
		if(root!=null){
			array.add(root.val);
			sum=sum-root.val;
		}
		if(root.left==null && root.right==null && sum==0){
			list.add(new ArrayList<Integer>(array));
		}
		if(root.left!=null){
			preordertraversal(root.left, sum, array, list);
			array.remove(array.size()-1);
			//sum=sum+root.left.val; useless, since when recursive function come back, it will recover its variable
		}
		if(root.right!=null){
			preordertraversal(root.right, sum, array, list);
			array.remove(array.size()-1);
			//sum=sum+root.right.val;
		}
	}
	public static void main(String[] args){
		TreeNode treenode1=new TreeNode(1);
		TreeNode treenode2=new TreeNode(2);
		TreeNode treenode3=new TreeNode(2);
		treenode1.left=treenode2;
		treenode1.right=treenode3;
		PathSum PS=new PathSum();
		System.out.print(PS.pathSum(treenode1,3));
	}

}

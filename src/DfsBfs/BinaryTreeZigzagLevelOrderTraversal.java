package DfsBfs;
//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
import java.util.List;
import java.util.LinkedList;
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(root==null)
            return res;
		LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		boolean zig=false;
		while(!queue.isEmpty()){
			zig=!zig;
			int size=queue.size();
			LinkedList<Integer> list=new LinkedList<Integer>();
			for(int i=0;i<size;i++){
				TreeNode front=queue.poll();
				if(zig)
					list.offer(front.val);
				else
					list.push(front.val);
				if(front.left!=null)
					queue.add(front.left);
				if(front.right!=null)
					queue.add(front.right);
				if(i==size-1)
					res.add(list);
			}
		}
		return res;
		
	}

}

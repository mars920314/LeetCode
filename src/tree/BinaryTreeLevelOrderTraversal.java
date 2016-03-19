package tree;
//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class BinaryTreeLevelOrderTraversal {
	//recursive
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        bfs(root, res, 0);
        return res;
    }
    void bfs(TreeNode root, List<List<Integer>> res, int level){
        if(root==null)
            return;
        if(res.size()<=level){
            List<Integer> tmp=new ArrayList<Integer>();
            tmp.add(root.val);
            res.add(tmp);
        }
        else
            res.get(level).add(root.val);
        bfs(root.left, res, level+1);
        bfs(root.right, res, level+1);
    }
    //iterate
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        if(root!=null)
            queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> list=new ArrayList<Integer>();
            while(size>0){
                TreeNode cur=queue.poll();
                list.add(cur.val);
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
                size--;
            }
            res.add(list);
        }
        return res;
    }
    //return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int currLevelNodeNum = 1;
        int nextLevelNodeNum = 0;
        while (currLevelNodeNum != 0) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
            nextLevelNodeNum = 0;
            while (currLevelNodeNum != 0) {
                TreeNode node = queue.poll();
                currLevelNodeNum--;
                currLevelResult.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevelNodeNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelNodeNum++;
                }
            }
            result.add(0, currLevelResult);
            currLevelNodeNum = nextLevelNodeNum;
        }
        return result;
    }
    //iterate
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
    	List<List<Integer>> res=new LinkedList<List<Integer>>();
    	if(root==null)
    		return res;
    	LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		ArrayList<Integer> list=new ArrayList<Integer>();
    		for(int i=0;i<size;i++){
    			TreeNode front=queue.poll();
    			list.add(front.val);
    			if(front.left!=null)
					queue.add(front.left);
				if(front.right!=null)
					queue.add(front.right);
    			if(i==size-1)
    				res.add(0,list);
    				
    		}
    	}
    	return res;
    }
}

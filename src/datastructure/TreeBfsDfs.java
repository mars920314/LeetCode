package datastructure;

import java.util.LinkedList;
public class TreeBfsDfs {
	//recursive
	void dfs(TreeNode root){
		if(root!=null){
			System.out.print(root.val);
			if(root.left!=null)
				dfs(root.left);
			if(root.right!=null)
				dfs(root.right);
		}
	}
	//iterate
	void dfs1(TreeNode root){
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur=stack.pop();
			System.out.print(cur.val);
			if(cur.right!=null)
				stack.push(cur.right);
			if(cur.left!=null)
				stack.push(cur.left);
		}
	}
	void bfs(TreeNode root){
		LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		int layer=0;
		while(!queue.isEmpty()){
			int size=queue.size();
			layer++;
			while(size>0){
				size--;
				TreeNode cur=queue.poll();
				System.out.print(cur.val);
				if(cur.left!=null)
					queue.offer(cur.left);
				if(cur.right!=null)
					queue.offer(cur.right);
			}
		}
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
		TreeBfsDfs TBD=new TreeBfsDfs();
		TBD.dfs(tree4);
		TBD.dfs1(tree4);
		TBD.bfs(tree4);
	}

}

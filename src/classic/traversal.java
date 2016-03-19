package classic;
import java.util.LinkedList;
public class traversal {
	void inordertraversal(TreeNode root){
		if(root==null)
			return;
		inordertraversal(root.left);
		System.out.print(root.val);
		inordertraversal(root.right);
	}
	//iteratively
	void inordertraversal1(TreeNode root){
        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        LinkedList<TreeNode> isVisited=new LinkedList<TreeNode>();
        if(root!=null){
            stack.push(root);
        }
		while(!stack.isEmpty()){
			TreeNode cur=stack.pop();
			if(isVisited.peek()==cur){
				System.out.print(cur.val);
			    isVisited.pop();
			}else{
			    isVisited.push(cur);
			    if(cur.right!=null)
    		        stack.push(cur.right);
			    stack.push(cur);
			    if(cur.left!=null)
			        stack.push(cur.left);
			}
		}
	}
	void preordertraversal(TreeNode root){
		if(root==null)
			return;
		System.out.print(root.val);
		preordertraversal(root.left);
		preordertraversal(root.right);
	}
	//iteratively
	void preordertraversal1(TreeNode root){
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		LinkedList<TreeNode> isVisited=new LinkedList<TreeNode>();
		if(root!=null){
            stack.push(root);
        }
		while(!stack.isEmpty()){
			TreeNode cur=stack.pop();
			if(isVisited.peek()==cur){
				System.out.print(cur.val);
			    isVisited.pop();
			}else{
				isVisited.add(cur);
				if(cur.right!=null)
					stack.push(cur.right);
				if(cur.left!=null)
					stack.push(cur.left);
				stack.push(cur);
			}
		}
	}
	void postordertraversal(TreeNode root){
		if(root==null)
			return;
		postordertraversal(root.left);
		postordertraversal(root.right);
		System.out.print(root.val);
	}
	//iteratively
	void postordertraversal1(TreeNode root){
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        LinkedList<TreeNode> isVisited=new LinkedList<TreeNode>();
        if(root!=null){
            stack.push(root);
        }
		while(!stack.isEmpty()){
			TreeNode cur=stack.pop();
			if(isVisited.peek()==cur){
				System.out.print(cur.val);
			    isVisited.pop();
			}else{
			    isVisited.push(cur);
			    stack.push(cur);
			    if(cur.right!=null)
    		        stack.push(cur.right);
			    if(cur.left!=null)
			        stack.push(cur.left);
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
/*
 * 			4
 * 		  /	  \
 * 		2		6
 * 	  /   \   /   \
 * 	1	   3 5		7
 */
		traversal Tra=new traversal();
		Tra.preordertraversal(tree4);
		Tra.preordertraversal1(tree4);
	}

}

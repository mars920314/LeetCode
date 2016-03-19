package dynamicProgramming;
//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//For example, Given n = 3, there are a total of 5 unique BST's.
import java.util.List;
import java.util.ArrayList;
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<n+1;i++)
            for(int j=0;j<i;j++)
                dp[i]=dp[i]+dp[j]*dp[i-1-j];
        return dp[n];
	}
	//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
	public List<TreeNode> generateTrees(int n) {
        return generate(1,n+1);
    }
    ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> res=new ArrayList<TreeNode>();
        if(start>=end){
            res.add(null);
            return res;
        }
        for(int i=start; i<end; i++){
            ArrayList<TreeNode> left=generate(start, i);
            ArrayList<TreeNode> right=generate(i+1, end);
            for(TreeNode leftnode:left)
            for(TreeNode rightnode:right){
                TreeNode node=new TreeNode(i);
                node.left=leftnode;
                node.right=rightnode;
                res.add(node);
            }
        }
        return res;
    }
	public static void main(String[] args){
		UniqueBinarySearchTrees UBST=new UniqueBinarySearchTrees();
		int n=2;
		System.out.print(UBST.numTrees(n));
	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int var){
		this.val=var;
	}
}

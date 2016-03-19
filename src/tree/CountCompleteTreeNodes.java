package tree;
//Given a complete binary tree, count the number of nodes.
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=heigh(root.left, 0);
        int right=heigh(root.right, 1);
        if(left==right)
            return (2<<(left+1-1))-1;
        else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
    public int heigh(TreeNode root, int lr){
        int h=0;
        while(root!=null){
            h++;
            if(lr==0)
                root=root.left;
            else
                root=root.right;
        }
        return h;
    }
    //binary search
    public int countNodes1(TreeNode root) {
    	if(root==null)
            return 0;
    	TreeNode tmp=root;
    	int nodenum=0;
        int left=leftheigh(tmp.left);
        while(tmp!=null){
        	int right=leftheigh(tmp.right);
        	if(left==right)
        		tmp=tmp.right;
            else
            	tmp=tmp.left;
            //nodenum=nodenum+2<<(right-1)-1+1;
        	nodenum = nodenum+ (1<<(right))-1+1;
            left--;
        }
        return nodenum;
    }
    public int leftheigh(TreeNode left){
    	int h=0;
        while(left!=null){
            h++;
            left=left.left;
        }
        return h;
    }
    public static void main(String[] args){
    	TreeNode tree=new TreeNode(1);
    	CountCompleteTreeNodes CCT=new CountCompleteTreeNodes();
    	System.out.print(CCT.countNodes1(tree));
    }
}

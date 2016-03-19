package DfsBfs;
//Given a binary tree, flatten it to a linked list in-place.
public class FlattenBinaryTreetoLinkedList {
	//preorder traversal, wrong
	TreeNode lastvisited = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode realright = root.right;
        if(lastvisited != null){
            lastvisited.left = null;
            lastvisited.right = root;
        }
        lastvisited = root;
        flatten(root.left);
        flatten(realright);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
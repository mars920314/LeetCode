package tree;
//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//Calling next() will return the next smallest number in the BST.
//Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
import java.util.LinkedList;
public class BinarySearchTreeIterator {
	LinkedList<TreeNode> stack=new LinkedList<TreeNode>();

    public BinarySearchTreeIterator(TreeNode root) {
        TreeNode tmp=root;
        while(tmp!=null){
            stack.push(tmp);
            tmp=tmp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur=stack.pop();
        TreeNode tmp=cur.right;
        while(tmp!=null){
            stack.push(tmp);
            tmp=tmp.left;
        }
        return cur.val;
    }

}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
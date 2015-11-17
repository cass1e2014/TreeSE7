import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * 
 * @author cassie9082
 * 
 */
public class BinarySearchTreeIterator {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}

	private TreeNode p;
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    //constructor
    public BinarySearchTreeIterator(TreeNode root) {
        this.p = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty() || p != null;
    }

    /** @return the next smallest number */
    public int next() {
        while(p != null){
            stack.push(p);
            p = p.left;
        }
        TreeNode curr = stack.pop();
        p = curr.right;
        
        return curr.val;
    }
}

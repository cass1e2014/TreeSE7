/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows: The left subtree of a node contains only
 * nodes with keys less than the node's key. The right subtree of a node
 * contains only nodes with keys greater than the node's key. Both the left and
 * right subtrees must also be binary search trees.
 * 
 * @author cassie9082
 * 
 */
public class ValidBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	//移动到最最左边开始判断是否valid，上一个值永远比当前root的value值要小才符合，所以也是一个判断条件。subtree左边右边都要判断
	private int lastValue = Integer.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		if(root == null){
			return true;
		}
		
		if(!isValidBST(root.left)){
			return false;
		}
		
		if(lastValue >= root.val){
			return false;
		}
		
		lastValue = root.val;
		
		if(!isValidBST(root.right)){
			return false;
		}
		return true;
	}
	
	
	//Solution 2:
	public boolean isValidBSTII(TreeNode root){
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	//helper class
	public boolean validate(TreeNode root, int min, int max){
		if(root == null){
			return true;
		}
		
		if(root.val <= min || root.val >= max){
			return false;
		}
		
		// left subtree must be < root.val && right subtree must be > root.val
		return validate(root.left, min, root.val) && validate(root.right, root.val, max);
	}
}

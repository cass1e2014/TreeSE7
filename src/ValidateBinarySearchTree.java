/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * @author cassie9082
 * 
 */
public class ValidateBinarySearchTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	int lastNodeValue = Integer.MAX_VALUE;
	boolean firstNode = true;
	public boolean isValidBST(TreeNode root) {
		if(root == null)	return true;
		//一路往下到达最左边
		if(!isValidBST(root.left))		return false;
		//不是第一个node && 上一层的node的val比当前node的val大，违背了bst，返回false
		if(!firstNode && lastNodeValue >= root.val)		return false;
		lastNodeValue = root.val;
		firstNode = false;
		if(!isValidBST(root.right))		return false;
		return true;
	}
}

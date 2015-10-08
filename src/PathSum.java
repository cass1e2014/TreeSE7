/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \      \
 *       7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * Time: o(n)
 * Space: o(logn)
 * 
 * @author cassie9082
 *
 */

public class PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		//这里不能把sum小于0加到判断条件里面，因为有可能node的value是负数，-2， -3 之和为-5
		if(root == null){
			return false;
		}
		//跳出recusion的条件！
		if(sum - root.val == 0 && root.left == null && root.right == null){
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	//solution 2?
}

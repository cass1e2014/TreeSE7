/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 		1
 * 	   / \
 *    2   3
 * 
 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path
 * 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author cassie9082
 * 
 */
public class SumRootToLeafNumbers {
	// DFS, remember to handle overflow problem
	long pathSum = 0;

	public int sumNumbers(TreeNode root) {
		sumNumbersHelper(root, 0);
		return (int) pathSum;
	}

	public void sumNumbersHelper(TreeNode root, long curSum) {
		if (root == null) {
			return;
		}
		curSum = curSum * 10 + root.val;
		if (root.left == null && root.right == null) {
			pathSum += curSum;
		}

		sumNumbersHelper(root.left, curSum);
		sumNumbersHelper(root.right, curSum);
	}
}

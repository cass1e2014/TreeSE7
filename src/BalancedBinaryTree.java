/**
 * Given a binary tree, determine if it is height-balanced. For this problem, a
 * height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 * 
 * @author cassie9082
 * 
 */
public class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null){
			return true;
		}
		return maxDepth(root) != -1;
	}
	
	//每个点往下传进入recrsion，node下没有child return 0，有任一小孩return 1， 最最左child和最最右child的差不能大于1，若大于1，则给上一层返回－1
	public int maxDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if(left == -1|| right == -1|| Math.abs(left - right) > 1){
			return -1;
		}
		return Math.max(left,right) + 1;
	}
}

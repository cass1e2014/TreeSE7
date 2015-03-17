
/*
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {
	public class TreeNode{
		int value;
		TreeNode left, right;
		public TreeNode(int x){
			value = x;
		}
	}
	public int minDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		//如果只有一层且没有孩子
		if(root.left == null && root.right == null){
			return 1;
		}
		
		//下面的3个＋1的意义不同
		if(root.left == null){
			return minDepth(root.right) + 1;
		}else if(root.right == null){
			return minDepth(root.left) + 1;
		}else{
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		}
	}
}

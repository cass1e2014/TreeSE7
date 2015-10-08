import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * @author cassie9082
 *
 */
public class MaximumDepthOfBinaryTree {
	public class TreeNode{
		int value;
		TreeNode left, right;
		public TreeNode(int x){
			value = x;
		}
	}
	
	
	//Method1
	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1; //记得要＋1
	}
	
	
	//Method 2
	public int maxDepth2(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int currentLevelNodesNumber = 1;
		int NextLevelNodesNumber = 0;
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			currentLevelNodesNumber --;
			if(cur.left != null){
				queue.offer(cur.left);
				NextLevelNodesNumber ++;
			}
			
			if(cur.right != null){
				queue.offer(cur.right);
				NextLevelNodesNumber ++;
			}
			
			if(currentLevelNodesNumber == 0){
				currentLevelNodesNumber = NextLevelNodesNumber;
				NextLevelNodesNumber = 0;
				depth ++;
			}
		}
		return depth;
	}
}

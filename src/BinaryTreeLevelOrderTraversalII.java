import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 * @author cassie9082
 *
 */
public class BinaryTreeLevelOrderTraversalII {
	public class TreeNode{
		int value;
		TreeNode left, right;
		public TreeNode(int x){
			value = x;
		}
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		
		Queue<TreeNode> queue = (Queue<TreeNode>) new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			ArrayList<Integer> level = new ArrayList<Integer>();
			
			for(int i = 0; i < queue.size(); i++){
				TreeNode curr = queue.poll();
				level.add(0, curr.value);//**
				if(curr.left != null){
					queue.offer(curr.left);
				}
				if(curr.right != null){
					queue.offer(curr.right);
				}
			}
		}
		return result;
	}
}

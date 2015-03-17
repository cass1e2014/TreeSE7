import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * binary tree : {3, 9, 20, #, #, 15, 7}
 * -->[
 *     [3],
 *     [9,20],
 *     [15,7]
 *    ]
 *     
 * @author cassie9082
 *
 */
public class BinaryTreeLevelOrderTraversal {
	
	public class TreeNode{
		int value;
		TreeNode left, right;
		public TreeNode(int x){
			value = x;
			left = null;
			right = null;
		}
	}
	
	public List<List<Integer>> BinaryTreeLevelOrderT(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		
		Queue<TreeNode> queue = (Queue<TreeNode>)new LinkedList<TreeNode>();//用queue来按顺序保存每一层的TreeNode
		
		queue.offer(root);
		while(!queue.isEmpty()){
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode curr = queue.poll();//通过poll来得到当前Node，加入每层返回的list，再判断该node是否有左右child，如果有加入到queue中
				level.add(curr.value);
				if(curr.left != null){
					queue.offer(curr.left);
				}
				if(curr.right != null){
					queue.offer(curr.right);
				}
			}
			result.add(level);
		}
		return result;
	}
}

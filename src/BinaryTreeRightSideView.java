import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example: Given the following binary tree,
 *    1            <---
 	/   \
   2     3         <---
    \     \
     5     4       <---
 * 
 * You should return [1, 3, 4]
 * @author cassie9082
 * 
 */
public class BinaryTreeRightSideView {
	// BFS
	// Add right child before adding the left child
	// For each level, only print out the first node(right-most node)
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (i == 0) {
					result.add(curr.val);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
				if (curr.left != null) {
					queue.add(curr.left);
				}
			}
		}
		return result;
	}
	
	//DFS
	public List<Integer> rightSideViewII(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
         
        if (root == null) {
            return result;
        }
         
        rightSideViewHelper(root, 0, result);
         
        return result;
    }
     
    private void rightSideViewHelper(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        //每次进入只要不是null都加到result的list中去
        //再做dfs，先做右边node，再做左边node
        if (level == result.size()) {
            result.add(root.val);
        }
         
        rightSideViewHelper(root.right, level + 1, result);
        rightSideViewHelper(root.left, level + 1, result);
    }

}

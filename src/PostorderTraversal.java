import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * binary tree:{40, 28, 78, 10, 32, #, #}
 * 
 * @author cassie9082
 * 
 */

// Left, Right, Parent
public class PostorderTraversal {
	public class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			left = null;
			right = null;
		}
	}

	// recursion
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		postorderTraversalHelper(root, result);
		return result;
	}

	public void postorderTraversalHelper(TreeNode root, List<Integer> result) {
		// recusion跳出的条件
		if (root == null) {
			return;
		}
		postorderTraversalHelper(root.left, result);
		postorderTraversalHelper(root.right, result);
		result.add(root.value);
	}

	// while-stack
	public List<Integer> postorderTraversalII(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode prev = null;

		while (!stack.empty()) {
			TreeNode curr = stack.peek();
			// go down the tree, check if current node is leaf. if so, process
			// it and pop stack or going down
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					result.add(curr.value);
				}
				// go up the tree from left node
				// need to check if there is a right child
				// if yes, push it to stack
				// otherwise, process parent and pop stack
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					result.add(curr.value);
				}
				// go up the tree from right node
				// after coming back from right node, process parent node and
				// pop stack.
			} else if (curr.right == prev) {
				stack.pop();
				result.add(curr.value);
			}
			prev = curr;
		}
		return result;
	}
}

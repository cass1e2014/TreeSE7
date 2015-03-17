import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * binary tree:{40, 28, 78, 10, 32, #, #}
 * @author cassie9082
 *
 */

//Parent, Left, Right
public class PreorderTraversal {
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
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		preorderTraversalHelper(root, result);
		return result;
	}
	
	public void preorderTraversalHelper(TreeNode root, List<Integer> result){
		if(root == null){
			return;
		}
		result.add(root.value);
		preorderTraversalHelper(root.left, result);
		preorderTraversalHelper(root.right, result);
	}
	
	//while-stack
	public List<Integer> preorderTraversalII(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()){
			TreeNode curr = stack.pop();
			result.add(curr.value);
			//push right child first so that it is processed after the left child.
			if(curr.right != null){
				stack.push(curr.right);
			}
			if(curr.left != null){
				stack.push(curr.left);
			}
		}
		return result;
	}
}

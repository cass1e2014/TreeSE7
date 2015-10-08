import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * binary tree:{40, 28, 78, 10, 32, #, #}
 * @author cassie9082
 *
 */

//Left, Parent, Right
public class InorderTraversal {
	public class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){
			left = null;
			right = null;
		}
	}
	//recursion
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		inorderTraversalHelper(root, result);
		return result;
	}
	
	public void inorderTraversalHelper(TreeNode root, List<Integer> result){
		if(root == null){
			return;
		}
		
		inorderTraversalHelper(root.left, result);
		result.add(root.value);
		inorderTraversalHelper(root.right, result);
	}
	
	//while-stack (存parent推进left）
	public List<Integer> inroderTraversalII(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;//define a pointer to track the node
		
		while(!stack.empty() || curr != null){
			//if it is not null, push it to the stack, and go down the tree to the left
			if(curr != null){
				stack.push(curr.left);
				curr = curr.left; //move the most left
			}else{
				TreeNode t = stack.pop(); 
				res.add(t.value); //print the value
				curr = t.right;//if the node has right child, move curr point to the right child
				//if not, curr = null, which means pop up the next value in the stack
			}
		}
		return res;
	}
}

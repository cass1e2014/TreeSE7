/**
 * Invert a binary tree.
 * 
 * 		4
 * 	   / \
 *    2   7
 *   / \ / \
 *  1  36   9
 *  翻转成-------
 * 		4
 * 	   / \
 *    7   2
 *   / \ / \
 *  9  63   1
 * @author cassie9082
 *
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if(root == null)	return null;
		invertTreeHelper(root);
		return root;
	}
	
	public void invertTreeHelper(TreeNode root){
		if(root == null)	return;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		invertTreeHelper(root.left);
		invertTreeHelper(root.right);
	}
}

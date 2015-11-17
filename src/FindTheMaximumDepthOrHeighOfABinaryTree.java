/**
 * Get the height of left sub tree, say leftHeight 
 * Get the height of right subtree, say rightHeight 
 * Take the Max(leftHeight, rightHeight) and add 1 for the root and return 
 * Call recur­sively.
 * 
 * @author cassie9082
 * 
 */
public class FindTheMaximumDepthOrHeighOfABinaryTree {
	public int treeHeight(Node root) {
		if (root == null)
			return 0;
		return (1 + (Math.max(treeHeight(root.left), treeHeight(root.right))));
	}
}

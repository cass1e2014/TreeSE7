/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 *     	_______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another
 * example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of
 * itself according to the LCA definition.
 * 
 * @author cassie9082
 * 
 */
public class LowestCommonAncestorOfABinaryTree {
	/*
	 * 1) If the binary tree itself is null, you don’t have any common ancestor.
	 * 2) If one of the two nodes is the root, then the root itself is the common ancestor.
	 * 3) Otherwise, recursively start finding the ancestor on the left node and right node. 
	 * 		If Node a and Node b lie in the left, their Lowest Common Ancestor is in the left. 
	 * 		If Node a and Node b lie in the right,their Lowest Common Ancestor is in the right.
	 * 		Otherwise, root is the Lowest common ancestor.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		// if Node a or Node b is also the root, then the root itself is the LCA
		if (root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		/*
		 * If Node p and Node q lie in the left, their LCA is in the left
		 * If Node p and Node q lie in the right, their LCA is in the right
		 */
		if (left != null & right != null) {
			return root;
		}
		return (left != null) ? left : right;
	}
}

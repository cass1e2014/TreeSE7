/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 */
public class RecoverBinarySearchTree {

	public class TreeNode {
		int value;
		TreeNode left, right;

		public TreeNode(int x) {
			value = x;
			left = null;
			right = null;
		}
	}

	private TreeNode firstElement = null;
	private TreeNode secondElement = null;
	private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {
		// traverse and get two elements
		traverse(root);
		// swap
		int temp = firstElement.value;
		firstElement.value = secondElement.value;
		secondElement.value = temp;
	}

	public void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(root.left);
		//首先移动到最左边node，因为方向是从树的底部往上走，所以之前node的值应该小于当前node的值 （inorder？？？）
		if(firstElement == null && root.value < lastElement.value){
			firstElement = lastElement;
			secondElement = root;
		}
		lastElement = root; //移动lastElement从tree的底部往上走
		traverse(root.right);
	}
}

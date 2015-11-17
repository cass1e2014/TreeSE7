

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Notes:
 * You may assume that duplicates do not exist in the tree.
 * @author cassie9082
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public class TreeNode{
		int value;
		TreeNode left, right;
		
		public TreeNode(int x){
			value = x;
		}
	}
	
	//Time: O(N^2) Space: O(N)
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length != postorder.length){
			return null;
		}
		return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}
	
	public int findPosition(int[] arr, int start, int end, int key){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == key){
				return i;
			}
		}
		return -1;
	}
	
	public TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
		if(instart > inend){
			return null;
		}
		
		//postorder的最后一位是root
		TreeNode root = new TreeNode(postorder[postend]);
		int position = findPosition(inorder, instart, inend, postorder[postend]);
		int leftNum = position - instart;
		root.left = myBuildTree(inorder, instart, position - 1, postorder, poststart, leftNum + poststart - 1);
		root.right = myBuildTree(inorder, position + 1, inend, postorder, leftNum + poststart, postend - 1);
		return root;
	}
	
}

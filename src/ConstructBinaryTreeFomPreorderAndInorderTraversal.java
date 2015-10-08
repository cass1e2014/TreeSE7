/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Notes:
 * You may assume that duplicates do not exist in the tree.
 * @author cassie9082
 *
 */
public class ConstructBinaryTreeFomPreorderAndInorderTraversal {
	public class TreeNode{
		int value;
		TreeNode left, right;
		
		public TreeNode(int x){
			value = x;
		}
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length != inorder.length){ //如果inorder喝preorder的长度不相等
			return null;
		}
		return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}
	
	//helper method. Find what is the position of "root(in preorder)" now is in inorder 
	public int findPosition(int[] arr, int start, int end, int key){
		for(int i = start; i < end; i++){
			if(arr[i] == key){
				return i;
			}
		}
		return -1;
	}
	
	public TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend){
		//首先写跳出recuion的条件
		if(instart > inend){
			return null;
		}
		
		//preorder的第一个是root，因为（P，L，R）
		TreeNode root = new TreeNode(preorder[prestart]);//**
		int position = findPosition(inorder, instart, inend, preorder[prestart]);
		
		//通过root在inorder中的位置判断树的左边有哪些，树的右边有哪些
		//position - instart得到左子数的数目，＋prestart得到相同数目的node在preorder中的位置
		int leftNum = position - instart;
		root.left = myBuildTree(inorder, instart, position - 1, preorder, prestart + 1, prestart + leftNum);
		root.right = myBuildTree(inorder, position + 1, inend, preorder, prestart + leftNum + 1, preend);
		return root;
	}
}

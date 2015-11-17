/**
 * Given a binary tree , Find the max ele­ment in it.
 * @author cassie9082
 *
 */
public class FindTheMaxElementInAGivenBinaryTree {
	//Use Recursion
	//Max will be :: Max(root, max element in left subtree, max element in right subtree
	//Recursively solve the max element in left subtree and right subtree
	public int getMax(Node root) {
		if(root == null)	return 0;
		return max(root.data, getMax(root.left), getMax(root.right));
	}
	
	public int max(int a, int b, int c){
		return Math.max(a, Math.max(a,  c));
	}
	
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data = data;
		}
	}
}

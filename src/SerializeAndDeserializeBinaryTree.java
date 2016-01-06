import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree
 * 
 * 		1
 * 	   / \
 * 	  2   3
 * 	     / \
 *      4   5
 *      
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
 * You do not necessarily need to follow this format, 
 * so please be creative and come up with different approaches yourself.
 * 
 * @author cassie9082
 * 
 */
public class SerializeAndDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr != null) {
				sb.append(curr.val);
				sb.append(" ");
				queue.offer(curr.left);
				queue.offer(curr.right);
			} else {
				sb.append("#");
				sb.append(" ");
			}
		}
		String result = sb.toString();
		return result;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}

		data = data.trim();
		String delim = " ";
		String[] arr = data.split(delim);

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
		queue.offer(root);

		int i = 1;

		while (!queue.isEmpty() && i < arr.length) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				TreeNode curr = queue.poll();
				if (!arr[i].equals("#")) {
					curr.left = new TreeNode(Integer.parseInt(arr[i]));
					queue.offer(curr.left);
				} else {
					curr.left = null;
				}
				i++;

				if (!arr[i].equals("#")) {
					curr.right = new TreeNode(Integer.parseInt(arr[i]));
					queue.offer(curr.right);
				} else {
					curr.right = null;
				}
				i++;
			}
		}
		return root;
	}

}

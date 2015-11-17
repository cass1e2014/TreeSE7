import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 		1
 * 	   / \
 *    2   3
 *     \
 *      5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * 
 * @author cassie9082
 * 
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null) {
			return result;
		}
		helper(result, new ArrayList<Integer>(), root);
		return result;
	}

	public void helper(List<String> result, List<Integer> crt, TreeNode root) {
		if (root == null) {
			return;
		} else {
			crt.add(root.val);
		}

		if (root.left == null && root.right == null) {
			result.add(getString(crt));
			return;
		}

		if (root.left != null) {
			// 这里每层都会传入一个新的list，就不用remove最后一个item了
			helper(result, new ArrayList<Integer>(crt), root.left);
		}
		if (root.right != null) {
			helper(result, new ArrayList<Integer>(crt), root.right);
		}

	}

	public String getString(List<Integer> crt) {
		if (crt == null || crt.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append(crt.get(0));
		for (int i = 1; i < crt.size(); i++) {
			sb.append("->").append(crt.get(i));
		}
		return sb.toString();
	}
}

import java.util.ArrayList;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \      \
 *       7    2      1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */

public class PathSumII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null || sum < 0){
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		pathSumHelper(root, sum, list, result);
		return result;
		
	}
	
	public void pathSumHelper(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
		if(root == null){
			return;
		}
		
		if(sum - root.val == 0 && root.left == null && root.right == null){
			list.add(root.val);//加最后的一个node
			result.add(new ArrayList<Integer>(list));
			list.remove(list.size()); //不建议直接remove掉那个值，可能之前的node会有相同的值，这里用index
		}
		
		list.add(root.val);//加非最后的node
		pathSumHelper(root.left, sum - root.val, list, result);
		pathSumHelper(root.right, sum - root.val, list, result);
		list.remove(list.size() - 1);
	}
}

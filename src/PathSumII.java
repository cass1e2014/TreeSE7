import java.util.ArrayList;
import java.util.Arrays;

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
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
	
public class PathSumII {
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null){
			return result;
		}//sum could be negative
		ArrayList<Integer> list = new ArrayList<Integer>();
		pathSumHelper(root, sum, list, result);
		return result;
		
	}
	
	public static void pathSumHelper(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
		if(root == null){
			return;
		}
		
		if(sum - root.val == 0 && root.left == null && root.right == null){
			list.add(root.val);//加最后的一个node
			result.add(new ArrayList<Integer>(list));//记得要new一个新的list obj
			list.remove(list.size() - 1); //不建议直接remove掉那个值，可能之前的node会有相同的值，这里用index
		}
		
		list.add(root.val);//加非最后的node
		pathSumHelper(root.left, sum - root.val, list, result);
		pathSumHelper(root.right, sum - root.val, list, result);
		list.remove(list.size() - 1);
	}
	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(5);
		TreeNode node10 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node6.left = node9;
		node6.right = node10;
		System.out.println(Arrays.toString(pathSum(node1, 22).toArray()));
	}
}

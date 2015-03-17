import java.util.LinkedList;
import java.util.Queue;

/*
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
	public class TreeNode {
		int value;
		TreeNode left, right;

		public TreeNode(int x) {
			value = x;
			left = null;
			right = null;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.value != q.value) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	// BFS的方法（用queue［linkedlist］和while）
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		queue1.offer(p);
		queue2.offer(q);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			if (queue1.size() != queue2.size()) {
				return false;
			}
			int size = queue1.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur1 = queue1.poll();
				TreeNode cur2 = queue2.poll();
				// 如果queue里面没有node
				if (cur1 == null && cur2 == null) {
					continue;
				}
				// 如果一个queue有node一个没有node
				if (cur1 == null || cur2 == null) {
					return false;
				}
				// 如果2个queue里面的node值不相等
				if (cur1.value != cur2.value) {
					return false;
				}
				// 把当前node的左右两边传到下一层去
				queue1.offer(cur1.left);
				queue1.offer(cur1.right);
				queue2.offer(cur2.left);
				queue2.offer(cur2.right);
			}
		}
		if(queue1.isEmpty() || queue2.isEmpty()){
			return false;
		}
		return true;
		
	}
}

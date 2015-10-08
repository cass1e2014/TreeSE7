import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode{
		int value;
		TreeNode left, right;
		public TreeNode(int x){
			value = x;
			left = null;
			right = null;
		}
	}
	
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null){
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int h = 0;//用来记录单双行数
		
		while(!queue.isEmpty()){
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < size; i++){
				TreeNode temp = queue.poll();
				if(h % 2 == 0){
					list.add(temp.value);
				}else{
					list.add(0, temp.value);
				}
				if(temp.left != null){
					queue.offer(temp.left);
				}
				if(temp.right != null){
					queue.offer(temp.right);
				}
			}
			result.add(list);
			h++;
		}
		return result;
	}
}

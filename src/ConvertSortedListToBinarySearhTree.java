/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * @author cassie9082
 * 
 */
public class ConvertSortedListToBinarySearhTree {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private ListNode current;
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null){
			return null;
		}
		current = head;
		int size = getSize(head);
		return sortedListTOBSTHelper(size);
	}
	
	public TreeNode sortedListTOBSTHelper(int size){
		if(size <= 0){
			return null;
		}
		//相当于inorder，left, parent, right
		TreeNode left = sortedListTOBSTHelper(size / 2);//左子树
		TreeNode root = new TreeNode(current.val);
		current = current.next;//移动到linkedlist的下一个元素，找到位置放在tree里
		TreeNode right = sortedListTOBSTHelper(size - 1 - size/2);//右子树
		
		root.left = left;
		root.right = right;
		return root;
	}
	
	
	//get size of linkedlist
	public int getSize(ListNode head){
		int size = 0;
		while(head != null){
			size ++;
			head = head.next;
		}
		return size;
	}
}

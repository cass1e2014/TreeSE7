/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 */
public class RecoverBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	TreeNode lastNode;
    TreeNode firstElement;
    TreeNode secondElement;
    public void recoverTree(TreeNode root) {
        lastNode = null;
        firstElement = null;
        secondElement = null;
        inorder(root);
        if(firstElement != null && secondElement != null){
            int tmp = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = tmp;
        }
    }
    
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        if(lastNode == null){
            lastNode = root;//lastNode初始化
        }else{
            if(lastNode.val > root.val){
                if(firstElement == null){
                    firstElement = lastNode;
                }
                secondElement = root;
            }
            lastNode = root;
        }
        inorder(root.right);
    }}

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
 * @author cassie9082
 *
 */



public class SymmetricTree {
	 public boolean isSymmetric(Node root) {
	        if(root == null){
	            return true;
	        }
	        
	        return isSymmetricHelper(root.left, root.right);
	    }
	    
	    public boolean isSymmetricHelper(Node left, Node right){
	        if(left == null && right == null){
	            return true;
	        }
	        
	        if(left == null || right == null){
	            return false;
	        }
	        
	        if(left.value != right.value){
	            return false;
	        }
	        
	        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
	    }
}

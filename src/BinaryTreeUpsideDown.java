import java.util.Stack;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a
 * sibling (a left node that shares the same parent node) or empty, flip it
 * upside down and turn it into a tree where the original right nodes turned
 * into left leaf nodes. Return the new root.
 * 
 * For example: Given a binary tree {1,2,3,4,5},
 * 
 * 		1
 * 	   /  \
 *    2    3
 *   / \
 *  4   5
 *  
 *  return the root of the binary tree [4,5,2,#,#,3,1]
 *  
 *  	4
 *     /  \
 *    5    2
 *        /  \
 *       3    1
 * 
 * @author cassie9082
 * 
 */
public class BinaryTreeUpsideDown {
    //原左节点变为了父节点，原父节点变味了有节点，
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null)    return null;
        while(root.left != null){
            stack.push(root);
            root = root.left;
        }
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            if(!stack.empty()){
                node.right = stack.peek();
                node.left = stack.peek().right;
            }else{
                node.right = null;
                node.left = null;
            }
        }
        return root;
    }
}


public class BST_Insertion {
	public Node myParent;   // Used by findNode() to save the previous node
	public Node root;
	
	   public Node findNode(double x)
	   {
	       Node curr_node;   // Points to the current node 
	       Node prev_node;   // Points to the previous node

	       /* --------------------------------------------
	          Find the node with search value == "x" in the BST
	          -------------------------------------------- */
	       curr_node = root;  // Always start at the root node
	       prev_node = root;  // Remember the previous node for insertion

	       while ( curr_node != null )
	       {
	          if ( x == curr_node.value )
	          {
	             // Found search value in BST
	             myParent = prev_node;        // Save in myParent
	             return curr_node;
	          }
	          else if ( x < curr_node.value  )
	          {
	             prev_node = curr_node;       // Remember prev. node 
	             curr_node = curr_node.left;  // Continue search in left subtree
	          }
	          else //  This must be true: ( x > curr_node.value )
	          {
	             prev_node = curr_node;       // Remember prev. node
	             curr_node = curr_node.right; // Continue search in right subtree
	          }
	       }

	       /* ======================================
	          When we reach here, x is NOT in BST
	          ====================================== */
	       myParent = prev_node;            // Save in myParent
	       return null;                     // Return not found
	   }
}

public class BST_Deletion {
	public Node root;
	
	/* =======================================================
    remove(x): delete node containg search value x
    ======================================================= */
 public void remove(double x)
 {
     Node p;        // Help variable
     Node parent;   // parent node
     Node succ;     // successor node

     /* --------------------------------------------
        Find the node with search value == "x" in the BST
        -------------------------------------------- */
     p = findNode(x);

     if ( p == null )
        return;               // Not found ==> nothing to delete....


     /* ========================================================
        Hibbard's Algorithm
        ======================================================== */

     /* =============================================
        Handel case 1: p has no children nodes
	  ============================================= */
     if ( p.left == null && p.right == null ) // Case 1: p has no children
     {
        if ( p == root )   // Special case...
        {
           root = null;
           return;
        }

        parent = myParent;     // myParent was set by findNode(x)....

        /* --------------------------------
           Delete p from p's parent
           -------------------------------- */
        if ( parent.left == p )
           parent.left = null;
        else
           parent.right = null;

        return;
     }

     /* -----------------------------------------------------------
        If program reach here, we know that:

            at least ONE of p.left or p.right is NOT null

        I.e.: p has at least 1 child node
	  ------------------------------------------------------------ */
     /* ===========================================================
        Handle case 2: p has 1 child node
	  =========================================================== */

     if ( p.right == null ) // If true: p.left ≠ null, p has left child
     {
        if ( p == root )   // Special case
        {
           root = root.left;
           return;
        }

        parent = myParent;     // myParent was set by findNode(x)....

        /* ----------------------------------------------
           Link p's left child as p's parent child
           ---------------------------------------------- */
        if ( parent.left == p )
           parent.left = p.left;
        else
           parent.right = p.left;

        return;
     }
	          
     if ( p.left == null ) // If true: p.right ≠ null, p has right child 
     {
        if ( p == root )   // Special case
        {
           root = root.right;
           return;
        }

        parent = myParent;     // myParent was set by findNode(x)....


        /* ----------------------------------------------
           Link p's right child as p's parent child
           ---------------------------------------------- */
        if ( parent.left == p )
           parent.left = p.right;
        else
           parent.right = p.right;

        return;
     }

     /* ================================================================
        Handle case 3: node has 2 children - find successor of p

        succ(p) is as as follows:  1 step right, all the way left

        Note: succ(p) has NOT left child !
        ================================================================ */

     if ( p.right.left == null )
     {
        /* ======================================================
           Special case: the right node of p IS the successor !
           Replace p with p.right
           ====================================================== */
        p.value = p.right.value;         // Replace p value
        p.right = p.right.right;         // Replace p right subtree

        return;                       // Done
     }

     succ = p.right;                  // Go RIGHT once
     Node succParent = p;             // We must also know succ's parent !

     /* ----------------------------------
        Find the successor node of node p
	  and successor's parent node
        --------------------------------- */
     while ( succ.left != null )
     {
         succParent = succ;           // Track succ's parent
         succ = succ.left;
     }

     /* ------------------------------
        Now we can delete p !
	  ------------------------------ */
     p.value = succ.value;           // Replace p with successor info.
     succParent.left = succ.right;   // Link right tree to parent's left
 }
}

package coding_challenge_30_day;

import java.util.Stack;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.<br/>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left
 * has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)<br/>
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.<br/>
 *
 * @author sudhir on 19-May-2020
 */
public class BSTFromPreorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Entry point of the method. This method takes O(n) time since we traverse the tree for every insertion and O(height) for inserting.
     * Total time complexity is O(n*height). If the tree is skewed, then the complexity will be O(n^2).
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = bstFromPreorder(root, preorder[i]);
        }
        return root;
    }

    private TreeNode bstFromPreorder(TreeNode root, int toInsert) {
        if (root == null) {
            root = new TreeNode(toInsert);
            return root;
        }
        // if the node value to be inserted is less than the current node, then travel left
        if (root.val > toInsert) {
            root.left = bstFromPreorder(root.left, toInsert);
        } else {
            // else travel right
            root.right = bstFromPreorder(root.right, toInsert);
        }
        return root;
    }

    /**
     * This iterative method uses stack that works in O(n) time.
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorderOptimizedIterative(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode temp = null;
            // Keep on popping while the stack is not empty and the next value is greater than stack’s top value.
            // Make this value as the right child of the last popped node. Push the new node to the stack.
            while (!st.isEmpty() && preorder[i] > st.peek().val) {
                temp = st.pop();
            }
            if (temp != null) {
                temp.right = new TreeNode(preorder[i]);
                st.push(temp.right);
            } else {
                // If the next value is less than the stack’s top value, make this value as the left child of the
                // stack’s top node. Push the new node to the stack.
                temp = st.peek();
                temp.left = new TreeNode(preorder[i]);
                st.push(temp.left);
            }
        }
        return root;
    }
}

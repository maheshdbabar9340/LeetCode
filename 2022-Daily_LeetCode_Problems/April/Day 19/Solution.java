// https://leetcode.com/problems/recover-binary-search-tree/

class Solution {
    // Creating three global pointers
    TreeNode previous = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        // Finding the two swapped nodes
        solve(root);

        // Swaping the value of nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    // New Function to find the two nodes
    public void solve(TreeNode root) {

        if (root == null) {
            return;
        }

        // Doing inorder traversal i.e, sarting from left then right
        solve(root.left);

        // If current node is smaller than previous, then previous node is invalid
        if (previous != null && root.val < previous.val) {

            // Storing previous node
            if (first == null) {
                first = previous;
            }

            // If both nodes are adjacent, save the current node in that case
            second = root;

        }

        // Making current node as previous node
        previous = root;

        // Moving to right sub-tree
        solve(root.right);

    }
}
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// Approach 1:

class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        while (root != null) {
            if (root.left != null) {
                TreeNode Left = root.left;
                TreeNode curr = Left;
                while (curr.right != null)
                    curr = curr.right;
                curr.right = root.right; // Morris Traversal main step
                root.left = null;
                root.right = Left;
            }
            root = root.right;
        }
    }
}

// Approach 2:

class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        // step-1
        TreeNode Left = root.left;
        TreeNode Right = root.right;

        // step-2
        root.left = null;

        // step-3
        flatten(Left);
        flatten(Right);
        root.right = Left;
        TreeNode curr = root;

        // step-4
        while (curr.right != null)
            curr = curr.right;

        // step-5
        curr.right = Right;
    }
}
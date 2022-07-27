// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

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
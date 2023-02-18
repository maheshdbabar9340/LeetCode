// Leetcode 226

class Solution {
    public TreeNode invertTree(TreeNode root) {

        // First process the root
        if(root==null) return null;
        TreeNode temp= root.left;
        root.left =root.right;
        root.right= temp;

        // Then the left subtree & lastly the right subtree
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

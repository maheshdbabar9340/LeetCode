// https://leetcode.com/problems/add-one-row-to-tree/

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        insertRowAtDepth(root, val, depth);
        return root;
    }
    
    public void insertRowAtDepth(TreeNode root, int val, int depth) {
        if (root == null) return;
        if (depth == 2) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            
            TreeNode lTemp = root.left;
            TreeNode rTemp = root.right;
            
            root.left = left;
            root.right = right;            
            
            left.left = lTemp;
            right.right = rTemp;
        } else {
            insertRowAtDepth(root.left, val, depth-1);
            insertRowAtDepth(root.right, val, depth-1);
        }
    }
} 

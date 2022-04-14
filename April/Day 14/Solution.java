// https://leetcode.com/problems/search-in-a-binary-search-tree/

// Recursive Approach

// Time Complexity : O(N)
// Space Complexity :O(N)

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;// Base Cases: root is null or val is present at root
        if (root.val > val)
            return searchBST(root.left, val); // Value is greater than root's val then search in right side of the root
        return searchBST(root.right, val);// Value is smaller than root's val then search in left side of the root
    }
}

// Itearative Appraoch

// Time Complexity : O(N)
// Space Complexity :O(1)

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null)
            return null;// Base Condition(If tree is empty )
        while (root != null && root.val != val) {// Tree is not empty and root value is not equals to val
            root = val < root.val ? root.left : root.right;// terminatory condition if val smaller than root value then
                                                           // search in left side else on right side
        }
        return root;
    }
}

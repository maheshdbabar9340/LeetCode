// https://leetcode.com/problems/convert-bst-to-greater-tree/

// Recursive Approach

// Time Complexity = O(n)
// Space Complexity = O(n)

class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}

// Itrative Approach

// Time Complexity = O(n)
// Space Complexity = O(n)

class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || node != null) {
            while (node != null) {
                st.add(node);
                node = node.right;
            }
            node = st.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
}
// https://leetcode.com/problems/increasing-order-search-tree/

// Time Complexity = O(n)
// Space Complexity = O(n)

class Solution {
    ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;

        inorder(root);

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i).left = null;
        }

        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;

        return list.get(0);
    }

    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(h) where h is the height of the tree

class Solution {
    TreeNode curr = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;

        TreeNode res = new TreeNode(0);
        curr = res;

        inorder(root);
        return res.right;
    }

    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        node.left = null;
        curr.right = node;
        curr = node;
        inorder(node.right);
    }
}
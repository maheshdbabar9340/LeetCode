// https://leetcode.com/problems/binary-tree-inorder-traversal/

class Solution {
    public List<Integer> inorder(TreeNode root, List<Integer> li) {
        if (root.right == null && root.left == null)
            li.add(root.val);
        else if (root.right == null) {
            inorder(root.left, li);
            li.add(root.val);
        } else if (root.left == null) {
            li.add(root.val);
            inorder(root.right, li);
        } else {
            inorder(root.left, li);
            li.add(root.val);
            inorder(root.right, li);
        }
        return li;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        List<Integer> arr = new ArrayList<Integer>();
        return inorder(root, arr);
    }
}
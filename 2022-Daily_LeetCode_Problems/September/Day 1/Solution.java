// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

class Solution {
    public int goodNodes(TreeNode root) {
        return needHelp(root, root.val);
    }

    public int needHelp(TreeNode node, int currentMax) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val >= currentMax) {
            count = 1;
            currentMax = node.val;
        }

        return count + needHelp(node.left, currentMax) + needHelp(node.right, currentMax);
    }
}
// https://leetcode.com/problems/binary-tree-right-side-view/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list, 0);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list, int depth) {
        if (node != null) {
            if (depth == list.size())
                list.add(node.val);

            helper(node.right, list, depth + 1);
            helper(node.left, list, depth + 1);
        }
    }
}
// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (hm.containsKey(k - curr.val))
                return true;
            else
                hm.put(curr.val, true);
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        return false;
    }
}
// https://leetcode.com/problems/binary-tree-right-side-view/

// Solution 1:

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

// Solution 2:

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); // store the number of nodes of current layer
            TreeNode node = null;
            while (size > 0) {
                node = queue.poll();
                if (node.left != null) // add next layer's node
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            list.add(node.val); // add the val of last node
        }

        return list;
    }
}
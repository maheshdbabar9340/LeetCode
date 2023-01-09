// https://leetcode.com/problems/binary-tree-preorder-traversal/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        if(root==null) return list;
        stack.offerLast(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            if(node==null) continue;
            list.add(node.val);
            stack.offerLast(node.right);
            stack.offerLast(node.left);
        }
        
        return list;
    }
}

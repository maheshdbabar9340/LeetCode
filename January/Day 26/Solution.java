// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

/**
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new LinkedList<Integer>();
        List<Integer> l2 = new LinkedList<Integer>();

        traverse(l1, root1);
        traverse(l2, root2);
        return combine(l1, l2);

    }

    private void traverse(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(list, node.left);
        list.add(node.val);
        traverse(list, node.right);
    }

    private List<Integer> combine(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new LinkedList<Integer>();
        int i = 0, j = 0;

        while (i < list1.size() || j < list2.size()) {
            if (i < list1.size() && j < list2.size()) {
                if (list1.get(i) < list2.get(j)) {
                    result.add(list1.get(i));
                    i++;
                } else {
                    result.add(list2.get(j));
                    j++;
                }
            } else if (i < list1.size()) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }
        return result;
    }
}
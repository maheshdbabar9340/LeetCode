// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

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
    private int maxDiff;
	
    public int maxAncestorDiff(TreeNode root) {
    	calculateMaxDiff(root, root.val, root.val);
    	
    	return maxDiff;
    }
    
    private void calculateMaxDiff(TreeNode root, int maxAncestor, int minAncestor) {
    	if (root == null) {
			return;
		}
    	// we only have positive values
    	maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - minAncestor), Math.abs(maxAncestor - root.val)));
    	maxAncestor = root.val > maxAncestor ? root.val : maxAncestor;
    	minAncestor = root.val < minAncestor ? root.val : minAncestor;
    	calculateMaxDiff(root.left, maxAncestor, minAncestor);
    	calculateMaxDiff(root.right, maxAncestor, minAncestor);
    	
    }
}

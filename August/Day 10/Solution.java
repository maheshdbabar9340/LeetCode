class Solution {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
    //Memory Usage: 43.8 MB, less than 47.11% of Java online submissions for Convert Sorted Array to Binary Search Tree.
    //recursive solution
    //DFS: pre-order
    //Time: O(N) ; Space:  O(logN)
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper_binaryBuilder(nums,0, nums.length-1) ;
    }

    private TreeNode helper_binaryBuilder(int[] nums, int left, int right){
        if (left > right) return null;
        int m = (right + left) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper_binaryBuilder(nums, left, m - 1);
        root.right = helper_binaryBuilder(nums, m + 1, right);
        return root;
    }
}
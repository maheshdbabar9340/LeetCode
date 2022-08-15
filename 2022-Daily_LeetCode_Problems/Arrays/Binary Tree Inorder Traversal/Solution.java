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

// First Approach iteratively
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         Stack<TreeNode> stack = new Stack();
//         List<Integer> list = new ArrayList();
        
//         while(!stack.empty() || root!=null){
//             while(root!=null){
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             list.add(root.val);
//             root = root.right;
//         }
//         return list;
//     }
// }

// Second Approach Recursively
class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        return dfs(root, new ArrayList());
    }
    
    private List<Integer> dfs(TreeNode root, List<Integer> list){
        if(root == null){
            return list;
        }
        
        //Inorder  = (left, root, right)
        list = dfs(root.left, list);
        list.add(root.val);
        return dfs(root.right, list);
    }
}
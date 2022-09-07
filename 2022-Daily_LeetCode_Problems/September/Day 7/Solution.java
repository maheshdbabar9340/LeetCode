// https://leetcode.com/problems/construct-string-from-binary-tree/

class Solution {
    StringBuilder sb;
    private void doEv(TreeNode root){
        if(root == null)return;
        if(root.left == null && root.right==null){
            sb.append(root.val);
            return;
        }
        sb.append(root.val);
        sb.append('(');
        doEv(root.left);
        sb.append(')');
        if(root.right!=null){
        sb.append('(');
        doEv(root.right);
        sb.append(')');
        }
        return;
    }
    public String tree2str(TreeNode t) {
        sb = new StringBuilder();
        doEv(t);
        return sb.toString();
    }
}
// https://leetcode.com/problems/binary-search-tree-iterator/

class BSTIterator {
    Queue<Integer> qu;

    public BSTIterator(TreeNode root) {
        qu = new LinkedList<>();
        inOrder(root);
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        qu.add(root.val);
        inOrder(root.right);
    }

    public int next() {
        return qu.remove();
    }

    public boolean hasNext() {
        return !qu.isEmpty();
    }
}
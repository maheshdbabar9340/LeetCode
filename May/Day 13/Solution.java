// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            Node prev = null;
            for (int i = 0; i < n; i++) {

                Node curr = q.poll();
                if (i == 0)
                    prev = curr;
                else {
                    prev.next = curr;
                    prev = curr;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return root;
    }
}
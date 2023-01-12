// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/

class Solution {
    private int[] res;
    private boolean[] visited;
    private class TreeNode {
        char val;
        int index;
        List<TreeNode> childs;
        TreeNode(char val, int index) { 
            this.val = val; 
            this.index = index;
            childs = new LinkedList<>();
        }
    }
    private Map<Character, Integer> dfs(TreeNode root) {
        Map<Character, Integer> map = new HashMap<>();
        if (root == null) return map;
        visited[root.index] = true;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        for (TreeNode child : root.childs) {
            if (visited[child.index]) continue;
            Map<Character, Integer>temp = dfs(child);
            if (temp.containsKey(root.val)) res[root.index] += temp.get(root.val);
            for (char key : temp.keySet()) {
                map.put(key, map.getOrDefault(key, 0) + temp.get(key));
            }
        }
        return map;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; ++i) nodes[i] = new TreeNode(labels.charAt(i), i);
        for (int i = 0; i < n - 1; ++i) {
            int a = edges[i][0], b = edges[i][1];
            nodes[a].childs.add(nodes[b]);
            nodes[b].childs.add(nodes[a]);
        }
        TreeNode root = nodes[0];
        res = new int [n];
        visited = new boolean[n];
        Arrays.fill(res, 1);
        dfs(root);
        return res;
    }
}

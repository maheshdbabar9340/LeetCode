// https://leetcode.com/problems/all-paths-from-source-to-target/description/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return helper(graph, new ArrayList<List<Integer>>(), new ArrayList<>(),0);
    }

    private List<List<Integer>> helper(int[][] graph, List<List<Integer>> result, List<Integer> path, int curr) {
        path.add(curr);
        if (curr == graph.length - 1) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return result;
        }
        
        for (int neighbor : graph[curr]) {
            helper(graph, result, path, neighbor);
        }
        path.remove(path.size() - 1);
        return result;
    }
}

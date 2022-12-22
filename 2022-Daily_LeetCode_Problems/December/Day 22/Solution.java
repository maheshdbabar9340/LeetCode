// https://leetcode.com/problems/sum-of-distances-in-tree/description/

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n <= 1) {
            return new int[]{0};
        }
        totalNodeCount = n;
        buildNodesMap(edges);
        calcChildrenCount(edges[0][0], -1);
        int fakeRootChildPathSum = childPathSumMap.get(edges[0][0]);
        int fakeRootChildCount =childCountMap.get(edges[0][0]) + 1;
        // Assume there is a fake root -1, then the total path sum of it will be fakeRootChildPathSum + fakeRootChildCount
        calcTotalPathSum(edges[0][0], -1, fakeRootChildPathSum + fakeRootChildCount);
        int[] result = new int[totalNodeCount];
        for (int i = 0; i < nodesMap.size(); ++ i) {
            result[i] = totalPathSumMap.get(i);
        }
        return result;
    }
    
    private HashMap<Integer, List<Integer>> nodesMap = new HashMap<>();
    private HashMap<Integer, Integer> childCountMap  = new HashMap<>();
    private HashMap<Integer, Integer> childPathSumMap  = new HashMap<>();
    private HashMap<Integer, Integer> totalPathSumMap = new HashMap<>();
    private int totalNodeCount = 0;
    
    private void buildNodesMap(int[][] edges) {
        for (int i = 0; i < edges.length; ++ i) {
            nodesMap.computeIfAbsent(edges[i][0], k -> new ArrayList<Integer>()).add(edges[i][1]);
            nodesMap.computeIfAbsent(edges[i][1], k -> new ArrayList<Integer>()).add(edges[i][0]);
        }
    }
    
    private void calcChildrenCount(int node, int parent) {
        int childrenSum = 0, pathSum = 0;
        for (int child : nodesMap.get(node)) {
            if (child == parent) {
                continue;
            }
            calcChildrenCount(child, node);
            int childrenCount = childCountMap.get(child) + 1;
            int pathCount = childPathSumMap.get(child);
            childrenSum += childrenCount;
            pathSum += pathCount;
        }
        pathSum += childrenSum;
        childCountMap .put(node, childrenSum);
        childPathSumMap .put(node, pathSum);
    }
    
    private void calcTotalPathSum(int node, int parent, int parentTotalPathSum) {
        int childNodeCount = childCountMap .get(node) + 1;
        int childPathSum = childPathSumMap .get(node);
        int otherTotalPathSum = parentTotalPathSum - (childNodeCount + childPathSum);
        int otherNodeCount = totalNodeCount - childNodeCount;
        int totalPathSum = childPathSum + otherTotalPathSum + otherNodeCount;
        totalPathSumMap.put(node, totalPathSum);
        for (int child : nodesMap.get(node)) {
            if (child == parent) {
                continue;
            }
            calcTotalPathSum(child, node, totalPathSum);
        }
    }
}

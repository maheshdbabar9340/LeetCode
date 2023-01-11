// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

class Solution {
    int res = 0;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            Set<Integer> list1 = map.getOrDefault(edge[0], new HashSet<>());
            Set<Integer> list2 = map.getOrDefault(edge[1], new HashSet<>());
            list1.add(edge[1]);
            list2.add(edge[0]);
            map.putIfAbsent(edge[0], list1);
            map.putIfAbsent(edge[1], list2);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(hasApple, map, 0, visited);
        return res;
    }
    
    public void dfs(List<Boolean> hasApple, Map<Integer, Set<Integer>> map, int index, boolean[] visited){
        Set<Integer> list1 = map.getOrDefault(index, new HashSet<>());
        for(int neighbour : list1){
            if(!visited[neighbour]){
                int temp = res;
                visited[neighbour] = true;
                if(hasApple.get(neighbour))
                    res += 2;
                dfs(hasApple, map, neighbour, visited);
                if(!hasApple.get(neighbour) && temp < res){
                    res += 2;
                }
            }
        }
    }
}

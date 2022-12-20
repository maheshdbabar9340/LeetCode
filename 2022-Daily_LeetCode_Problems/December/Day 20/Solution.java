// https://leetcode.com/problems/keys-and-rooms/description/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() == 0) return true;
        boolean[] visited = new boolean[rooms.size()];
        dfs(0,rooms,visited);
        for(int i=0;i<rooms.size();i++)
            if(!visited[i])
                return false;
        return true;
    }
    public void dfs(int index,List<List<Integer>> rooms,boolean[] visited){
        visited[index] = true;
        for(int n:rooms.get(index)){
            if(!visited[n]){
                dfs(n,rooms,visited);
            }
        }
    }
}

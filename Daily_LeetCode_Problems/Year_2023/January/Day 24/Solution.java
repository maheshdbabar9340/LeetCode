// https://leetcode.com/problems/snakes-and-ladders/description/

class Solution {
    int ans = Integer.MAX_VALUE;
    public int snakesAndLadders(int[][] board) {
        // Contruct the mapping of snakes and ladders
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 1;
        int x = board.length, y = board[0].length, N = x*y;
        for(int i = x-1; i >= 0; i--) {
            if(i%2 == (x-1)%2){
                for(int j = 0; j < y; j++, cnt++) {
                    if(board[i][j] != -1) map.put(cnt, board[i][j]);
                }
            } else {
                for(int j = y-1; j >= 0; j--, cnt++) {
                    if(board[i][j] != -1) map.put(cnt, board[i][j]);
                }   
            }
        }
        // BFS search
        HashSet<Integer> visited = new HashSet<>();
        visited.add(1);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0}); // (position, step)
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0], step = cur[1];
            if(pos == N) ans = Math.min(ans, step);
            else if(pos < N && step < ans){
                for(int i = 6; i > 0; i--) {
                    int next = pos + i;
                    if(map.containsKey(next)) next = map.get(next);
                    if(!visited.contains(next) && next <= N && step+1 < ans){
                        visited.add(next);
                        queue.add(new int[]{next, step+1});
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

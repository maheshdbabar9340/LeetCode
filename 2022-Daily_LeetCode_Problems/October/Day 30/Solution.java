class Solution {
    private static int[] di = new int[] {0,  0, 1, -1};
    private static int[] dj = new int[] {1, -1, 0,  0};
    
    record Cell (int i, int j, int steps, int k) {}

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, max = m + n - 2;
        if (k > max - 2) return max;
        int[][] visited = new int[m][n];
        for (var a : visited) Arrays.fill(a, -1);
        
        Queue<Cell> q = new ArrayDeque<>();
        Cell c0 = new Cell(0, 0, 0, k);
        visited[0][0] = k;
        q.offer(c0);
        
        while (!q.isEmpty()) {
            Cell cur = q.poll();
            if (cur.i == m-1 && cur.j == n-1) return cur.steps;
            for (int i = 0; i < 4; i++) {
                int i2 = cur.i + di[i], j2 = cur.j + dj[i];
                if (i2 < 0 || j2 < 0 || i2 >= m || j2 >= n) continue;
                int k2 = cur.k - grid[i2][j2];
                if (k2 <= visited[i2][j2]) continue;
                visited[i2][j2] = k2;
                q.offer(new Cell(i2, j2, cur.steps+1, k2));
            }
        }
        
        return -1;
    }
}

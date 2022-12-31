// https://leetcode.com/problems/unique-paths-iii/description/

class Solution {
  private int res = 0;
	private int walks = 0;
	private static final int[][] NEXTS = new int[][] {
			{0, 1}, {0, -1}, {-1, 0}, {1, 0}
	};
	public int uniquePathsIII(int[][] grid) {
		res = 0;
		walks = 0;
		int row = 0, col = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					walks++;
				} else if (grid[i][j] == 1) {
					row = i;
					col = j;
				}
			}
		}
		dfs(grid, row, col, 0);
		return res;
	}

	private void dfs(int[][] grid, int row, int col, int walked) {
		if (row < 0 || row >= grid.length || col < 0
				|| col >= grid[row].length || grid[row][col] < 0) {
			return;
		}
		if (grid[row][col] == 2 && walked == walks + 1) {
			res++;
			return;
		}
		int val = grid[row][col];
		grid[row][col] = -2;
		for (int[] next : NEXTS) {
			dfs(grid, row + next[0], col + next[1], walked + 1);
		}
		grid[row][col] = val;
	}
}

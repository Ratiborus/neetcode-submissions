class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new HashSet<>());
    }

    private int dfs(int[][] grid, int r, int c, Set<Map.Entry> set) {
        int row = grid.length;
        int col = grid[0].length;
        if (r < 0 || c < 0 || r == row || c == col || set.contains(Map.entry(r, c)) || grid[r][c] == 1) {
            return 0;
        }
        if (r == row - 1 && c == col - 1) {
            return 1;
        }
        set.add(Map.entry(r, c));
        int count = 0;
        count += dfs(grid, r - 1, c, set);
        count += dfs(grid, r + 1, c, set);
        count += dfs(grid, r, c - 1, set);
        count += dfs(grid, r, c + 1, set);
        set.remove(Map.entry(r, c));
        return count;
    }
}

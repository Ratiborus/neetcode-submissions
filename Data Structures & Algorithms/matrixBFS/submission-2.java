class Solution {
    public int shortestPath(int[][] grid) {
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
        int count = 0;
        q.offer(Map.entry(0, 0));
        int row = grid.length;
        int col = grid[0].length;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                var cor = q.poll();
                if (cor.getKey() == row - 1 && cor.getValue() == col - 1 && grid[cor.getKey()][cor.getValue()] == 0) {
                    return count;
                }
                int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for(int[] d : dir) {
                    int r = cor.getKey() + d[0];
                    int c = cor.getValue() + d[1];
                    if (r < 0 || c < 0 || r == row || c == col || grid[r][c] == 1 || visited.contains(Map.entry(r, c))) {
                        continue;
                    }
                    var e = Map.entry(r, c);
                    q.offer(e);
                    visited.add(e);
            }
            }
            count++;
        }

        return -1;
    }


}

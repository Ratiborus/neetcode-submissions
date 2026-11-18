class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> min = new PriorityQueue<int[]>((a, b) -> Double.compare(getDist(a), getDist(b)));
        for(int[] p : points) {
            min.add(p);
        }
        int[][] res = new int[k][];
        for(int i = 0; i < k; i++) {
            res[i] = min.poll();
        }
        return res;
    }

    private double getDist(int[] point) {
        double a = 0D + point[0];
        double b = 0D + point[1];
        return Math.abs(Math.sqrt(Math.pow(a, 2D) + Math.pow(b, 2D)));
    }
}

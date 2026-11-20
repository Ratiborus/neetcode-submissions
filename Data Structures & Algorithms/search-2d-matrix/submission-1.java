class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length - 1;
        int t = -1;
        while(e >= s) {
            int m = s + (e - s)/2;
            if (matrix[m][0] <= target && matrix[m][matrix[m].length-1] >= target) {
                t = m;
                break;
            } else if (target < matrix[m][0]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        if (t < 0) {
            return false;
        }
        s = 0;
        e = matrix[t].length - 1;
        while(s <= e) {
            int m = s + (e - s)/2;
            if (matrix[t][m] == target) {
                return true;
            } else if (matrix[t][m] > target) {
                e = m -1;
            } else {
                s = m + 1;
            }
        }
        return false;
    }
}

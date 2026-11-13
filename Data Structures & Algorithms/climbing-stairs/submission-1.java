class Solution {
    public int climbStairs(int n) {
        return climb(n, new int[n + 1]);
    }

    public int climb(int n, int[] mem) {
        if (mem[n] != 0) {
            return mem[n];
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        mem[n] = climb(n - 1, mem) + climb(n - 2, mem);
        return mem[n];
    }
    
    //climb(3) = climb(2) + climb(0) = 3
    //climb(2) = climb(1) + climb(0) = 2 
    //climb(1) = 1
    //climb(0) = 1

    //climb(4) = climb(3) + climb(2) = 5
}

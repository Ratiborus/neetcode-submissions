class Solution {
    public void sortColors(int[] nums) {
        int[] col = new int[3];
        for(int n : nums) {
            col[n]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (col[0] > 0) {
                nums[i] = 0;
                col[0]--;
            } else if(col[1] >0) {
                nums[i] = 1;
                col[1]--;
            } else if(col[2] > 0) {
                nums[i] = 2;
                col[2]--;
            }
        }
    }
}
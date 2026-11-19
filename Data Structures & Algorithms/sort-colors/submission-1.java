class Solution {
    public void sortColors(int[] nums) {
        int[] col = new int[3];
        for(int n : nums) {
            col[n]++;
        }
        int j = 0;
        for(int c = 0; c < col.length; c++) {
            for(int i = 0; i < col[c]; i++) {
                nums[j++] = c;
            }
        }
    }
}
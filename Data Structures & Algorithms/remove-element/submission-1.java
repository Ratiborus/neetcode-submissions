class Solution {
    public int removeElement(int[] nums, int val) {
        //  l = 1
        //  r = 2
        //  val = 2
        // [2,2,2,3]
        //        r
        //       l
        //  [2,2,2]
        //       r 
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != val) {
                nums[l++] = nums[r];
            }
        }
        return l;
    }
}
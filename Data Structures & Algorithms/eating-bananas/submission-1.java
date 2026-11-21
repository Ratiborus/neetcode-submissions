class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        for(int n : piles) {
            k = k < n ? n : k;
        }
        int s = 1;
        int res = k;//4
        while(s <= k) {
            int m = s + (k - s)/2;
            if (success(piles, m, h) < 0) {
                s = m + 1;
            } else {
                res = m;
                k = m - 1;
            }
        }
        return res;
    }

    private int success(int[] p, int m, int h) {
        for(int pile : p) {
            int tmph = pile / m;
            h -= tmph;
            if (tmph * m < pile) {
                h--;
            }
        }
        return h;
    }
}

class Solution {
    public int[] replaceElements(int[] arr) {
        /*
            max = 1
            tmp = 0
            l = 0
            r = 0
               l
            [1]
                       r

        */
        int max = arr[arr.length-1];
        int l = arr.length-2;
        for(int r = arr.length - 1; r > 0 && l >=0; r--) {
            int tmp = arr[l];
            arr[l--] = max;
            max = max < tmp ? tmp : max;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    public void quickSort(List<Pair> arr, int s, int e) {
        if (e - s + 1 <= 1) {
            return;
        }

        Pair pivot = arr.get(e);
        int left = s;

        for(int i = s; i < e; i++) {
            if(arr.get(i).key < pivot.key) {
                Pair tmp = arr.get(i);
                arr.set(i, arr.get(left));
                arr.set(left, tmp);
                left++;
            }
        }

        arr.set(e, arr.get(left));
        arr.set(left, pivot);
        quickSort(arr, s, left - 1);
        quickSort(arr, left + 1, e);
    }
}

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
        sort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    private void sort(List<Pair> list, int s, int e) {
        if (e - s + 1 <= 1) {
            return;
        }

        Pair pivot = list.get(e);
        int left = s;

        for (int i = s; i < e; i++) {
            if (list.get(i).key < pivot.key) {
                Pair tmp = list.get(left);
                list.set(left, list.get(i));
                list.set(i, tmp);
                left++;
            }
        }

        list.set(e, list.get(left));
        list.set(left, pivot);
        sort(list, s, left - 1);
        sort(list, left+1, e);
    }
}

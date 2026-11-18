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
                Pair next = list.get(left);
                Pair prev = list.get(i);
                list.add(i, next);
                list.remove(i+1);
                list.add(left, prev);
                list.remove(left+1);
                left++;
            }
        }

        list.add(e, list.get(left));
        list.remove(e+1);
        list.add(left, pivot);
        list.remove(left+1);
        sort(list, s, left - 1);
        sort(list, left+1, e);
    }
}

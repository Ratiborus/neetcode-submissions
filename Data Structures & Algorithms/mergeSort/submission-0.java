// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        mergeSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    public void mergeSort(List<Pair> pairs, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(pairs, l, m);
            mergeSort(pairs, m + 1, r);
            merge(pairs, l, m, r);
        }
    }

    public void merge(List<Pair> pairs, int l, int m, int r) {
        int size1 = m - l + 1;
        int size2 = r - m;

        List<Pair> left = new ArrayList();
        List<Pair> right = new ArrayList();

        for(int i = 0; i < size1; i++) {
            left.add(pairs.get(i + l));
        }
        for(int i = 0; i < size2; i++) {
            right.add(pairs.get(i + m + 1));
        }

        int ls = 0;
        int lr = 0;
        int main = l;

        while(ls < size1 && lr < size2) {
            pairs.remove(main);
            if(left.get(ls).key <= right.get(lr).key) {
                pairs.add(main, left.get(ls));
                ls++;
            } else {
                pairs.add(main, right.get(lr));
                lr++;
            }
            main++;
        }

        while(ls < size1) {
            pairs.remove(main);
            pairs.add(main, left.get(ls));
            ls++;
            main++;
        }

        while(lr < size2) {
            pairs.remove(main);
            pairs.add(main, right.get(lr));
            lr++;
            main++;
        }
    }
}

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
        int s = 0;
        int e = pairs.size() - 1;
        return sort(pairs, s, e);
    }

    private List<Pair> sort(List<Pair> list, int s, int e) {
        if (e - s + 1 <= 1) {
            return list;
        }

        int m = (s + e) / 2; 

        sort(list, s, m);
        sort(list, m + 1, e);
        merge(list, s, m, e);
        return list;
    }

    private void merge(List<Pair> list, int s, int m, int e) {
        int ls = m - s + 1;
        int rs = e - m;

        Pair[] la = new Pair[ls];
        Pair[] ra = new Pair[rs];

        for(int i = 0; i < ls; i++) {
            la[i] = list.get(s+i);
        }
        for(int i = 0; i < rs; i++) {
            ra[i] = list.get(m+i+1);
        }

        int i = 0;
        int j = 0;
        int k = s;

        while(i < ls && j < rs) {
            if (ra[j].key < la[i].key) {
                list.remove(k);
                list.add(k++, ra[j++]);
            } else {
                list.remove(k);
                list.add(k++, la[i++]);
            }
        }
        while(i < ls) {
            list.remove(k);
            list.add(k++, la[i++]);
        }
        while(j < rs) {
            list.remove(k);
            list.add(k++, ra[j++]);
        }
    }
}

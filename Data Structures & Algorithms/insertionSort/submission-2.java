// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> list = new ArrayList<>();
        if (pairs.size() == 0) {
            return list;
        }
        list.add(copy(pairs));
        for(int i = 1; i < pairs.size(); i++) {
            int j = i;
            while(j > 0 && pairs.get(j).key < pairs.get(j - 1).key) {
                Pair right = pairs.get(j-1);
                Pair left = pairs.get(j);
                pairs.remove(j);
                pairs.remove(j-1);
                pairs.add(j-1, left);
                pairs.add(j, right);
                j--;
            }
            list.add(copy(pairs));
        }

        return list;
    }
}

private List<Pair> copy(List<Pair> pairs) {
    List<Pair> list = new ArrayList<>();
    for(Pair p : pairs) {
        list.add(new Pair(p.key, p.value));
    }
    return list;
}

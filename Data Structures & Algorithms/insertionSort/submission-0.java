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
        List<List<Pair>> result = new ArrayList<>();
        for(int i = 0; i < pairs.size(); i++) {
            int j = i;
            while (j > 0 && pairs.get(j).key < pairs.get(j - 1).key) {
                pairs.add(j - 1, pairs.remove(j));
                j--;
            }
            result.add(new ArrayList<>(pairs));
        }
        return result;
    }
}

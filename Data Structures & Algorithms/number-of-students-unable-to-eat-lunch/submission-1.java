class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] want = new int[2];
        for(int s : students) {
            want[s]++;
        }

        for (int sand : sandwiches) {
            if (want[sand] > 0) {
                want[sand]--;
            } else {
                if (sand == 1) {
                    return want[0];
                } else {
                    return want[1];
                }
            }
        }
        return 0;
    }
}
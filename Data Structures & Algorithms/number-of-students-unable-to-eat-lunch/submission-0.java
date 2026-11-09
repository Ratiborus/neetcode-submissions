class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        if (students.length == 0) {
            return 0;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i : students) {
            q.add(i);
        }
        int counter = 0;
        int i = 0;
        while(q.size() > 0 && counter < q.size()) {//change it !!!
            if (sandwiches[i] == q.peek().intValue()) {
                i++;
                q.remove();
                counter = 0;
            } else {
                q.offer(q.poll());
                counter++;
            }
        }
        return q.size();
    }
}
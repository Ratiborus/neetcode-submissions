class Graph {

    Map<Integer, Set<Integer>> map;

    public Graph() {
        map = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if (!map.containsKey(src)) {
            map.put(src, new HashSet<>());
        }
        if (!map.containsKey(dst)) {
            map.put(dst, new HashSet<>());
        }
        map.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!map.containsKey(src) || !map.get(src).contains(dst)) {
            return false;
        }
        map.get(src).remove(dst);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                var n = q.poll();
                if (vis.contains(n)) {
                    continue;
                }
                if (n == dst) {
                    return true;
                }
                vis.add(n);
                for(int p : map.get(n)) {
                    q.offer(p);
                }
            }
        }
        return false;
    }
}

class HashTable {

    List<Pair>[] map;
    int size = 0;

    public HashTable(int capacity) {
        map = new List[capacity];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<Pair>();
        }
    }

    public void insert(int key, int value) {
        int i = getIndex(key);
        Optional<Pair> pair = map[i].stream()
        .filter(p -> p.key == key)
        .findFirst();
        if (pair.isPresent()) {
            pair.get().val = value;
            return;
        }
        map[i].add(new Pair(key, value));
        size++;
        if (size == map.length / 2) {
            resize();
        }
    }

    public int get(int key) {
        int i = getIndex(key);
        return map[i].stream()
        .filter(p -> p.key == key) 
        .map(p -> p.val)
        .findFirst()
        .orElse(-1);
    }

    public boolean remove(int key) {
        int i = getIndex(key);
        Optional<Pair> pair = map[i].stream()
            .filter(p -> p.key == key)
            .findFirst();
        if (pair.isEmpty()) {
            return false;
        }
        map[i].remove(pair.get());
        size--;
        return true;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return map.length;
    }

    public void resize() {
        var old = map;
        map = new List[map.length * 2];
        size = 0;
        for (int i = 0; i < map.length;i++) {
            map[i] = new ArrayList<Pair>();
        }
        for (List<Pair> l : old) {
            for(Pair p : l) {
                insert(p.key, p.val);
            }
        }
    }

    public static class Pair {
        int key;
        int val;

        public Pair(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    private int getIndex(int key) {
        return key % map.length;
    }
}

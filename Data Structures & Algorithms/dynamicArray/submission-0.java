class DynamicArray {

    private int[] arr;
    private int pointer = 0;

    public DynamicArray(int capacity) {
        arr = capacity > 0  ? new int[capacity] : new int[0];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (pointer > arr.length - 1) {
            resize();
        }
        arr[pointer++] = n;
    }

    public int popback() {
        return arr[--pointer];
    }

    private void resize() {
        int[] doubled = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            doubled[i] = arr[i];
        }
        arr = doubled;
    }

    public int getSize() {
        return pointer;
    }

    public int getCapacity() {
        return arr.length;
    }
}

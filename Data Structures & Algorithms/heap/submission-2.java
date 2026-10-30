class MinHeap {

    List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    /*
    [35,1, 5, 22, 7, 15, 2, 4]
    create -> [0]
    35 -> [0,35]
    1 -> [0,35,1] -> [0, 1, 35]
            1
           /\
          35
    5 -> [0,1,35,5] -> []
            1
            /\
            35 5
    */
    public void push(int val) {
        if (heap.size() == 1) {
            heap.add(val);
        } else {
            heap.add(val);
            heapifyUpa(heap.size() - 1);
        }
    }

    public Integer pop() {
        if (heap.size() == 1) {
            return -1;
        } 
        Integer top = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        String afterAdd = heap.toString();
        heap.remove(heap.size() - 1);
        String afterRemove = heap.toString();
        heapifyDown(1);
        return top;
    }

    public Integer top() {
        if (heap.size() == 1) {
            return -1;
        }
        return heap.get(1);
    }

    public void heapify(List<Integer> nums) {
        for(Integer n : nums) {
            push(n);
        }
    }

    private void heapifyUpa(int index) {
        int cur = index;
        while(hasParent(cur) && getParent(cur) > heap.get(cur)) {
            var parent = getParent(cur);
            var child = heap.get(cur);
            heap.set(getParentIndex(cur), child);
            heap.set(cur, parent);
            cur = getParentIndex(cur);
        }
    }

    private void heapifyDown(int index) {
        int cur = index;
        while(hasChildren(cur)) {
            if (hasLeftChild(cur) && hasRightChild(cur)) {
                int minIndex = getLeftChild(cur) < getRightChild(cur) ? getLeftChildIndex(cur) : getRightChildIndex(cur);
                if (heap.get(cur) > heap.get(minIndex)) {
                    int tmp = heap.get(cur);
                    heap.set(cur, heap.get(minIndex));
                    heap.set(minIndex, tmp);
                    cur = minIndex;
                } else {
                    break;
                }
            } else if (hasLeftChild(cur))  {
                int minIndex = getLeftChildIndex(cur);
                if (heap.get(cur) > heap.get(minIndex)) {
                    int tmp = heap.get(cur);
                    heap.set(cur, heap.get(minIndex));
                    heap.set(minIndex, tmp);
                    cur = minIndex;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private int getParentIndex(int index) {
        return index / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 1;
    }

    private Integer getLeftChild(int index) {
        return heap.get(getLeftChildIndex(index));
    }

    private Integer getRightChild(int index) {
        return heap.get(getRightChildIndex(index));
    }

    private Integer getParent(int index) {
        return heap.get(getParentIndex(index));
    }

    private boolean hasParent(int index) {
        int i = getParentIndex(index);
        return i > 0 && i < heap.size();
    }

    private boolean hasLeftChild(int index) {
        return heap.size() > getLeftChildIndex(index);
    } 

    private boolean hasRightChild(int index) {
        return heap.size() > getRightChildIndex(index);
    }

    private boolean hasChildren(int index) {
        return hasLeftChild(index) || hasRightChild(index);
    }
}

class MyLinkedList {

    private final Node dummy;
    private Node tail;
    private int size = 0;

    public MyLinkedList() {
        dummy = create(null, null, 0);
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return getNode(index).val;
    }
    
    public void addAtHead(int val) {
        Node newHead = create(dummy, dummy.next, val);
        size++;
        if (size == 1) {
            tail = newHead;
        }
    }
    
    public void addAtTail(int val) {
        tail = create(tail, null, val);
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if(size == index) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            Node n = getNode(index);
            Node prev = n.prev;
            Node newNode = create(prev, n, val);
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node del = getNode(index);
        del.prev.next = del.next;
        if (del.next != null) {
            del.next.prev = del.prev;
        } else {
            tail = del.prev;
        }
        del.prev = null;
        del.next = null;
        size--;
    }

    private Node getNode(int idx) {
        Node tmp = dummy;
        for(int i = 0; i <= idx; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    private Node create(Node prev, Node next, int val) {
        Node n = new Node();
        n.prev = prev;
        n.next = next;
        n.val = val;
        if (prev != null) {
            prev.next = n;
        }
        if (next != null) {
            next.prev = n;
        }
        return n;
    }

    public static class Node {
        public Node next;
        public Node prev;
        public int val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
class LinkedList {

    private final Node head;
    private Node tail;
    private int size = 0;


    public LinkedList() {
        head = create(null, null, 0);
        tail = head;
    }

    public int get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return -1;
        }
        Node res = head;
        for (int i = 0; i < index+1; i++) {
            res = res.next;
        }
        return res.val;
    }

    public void insertHead(int val) {
        size++;
        Node newHead = create(head, head.next, val);
        if (tail == head) {
            tail = newHead;
        }
    }

    public void insertTail(int val) {
        Node newTail = create(tail, null, val);
        tail = newTail;
        size++;
    }

    public boolean remove(int index) {
        if(size == 0 || index < 0 || index >= size) {
            return false;
        }
        Node tmp = head;
        for (int i = 0; i < index + 1; i++) {
            tmp = tmp.next;
        }
        Node prev = tmp.prev;
        Node next = tmp.next;
        tmp.next = null;
        tmp.prev = null;
        prev.next = next;
        if (tmp == tail) {
            tail = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        Node pt = head;
        for (int i = 0; i < size; i++) {
            pt = pt.next;
            list.add(pt.val);
        }
        return list;
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
        public Node prev;
        public Node next;
        public int val;
    }
}

class MinStack {

    private final Node head;
    private Node tail;
    private Node min = null;

    public MinStack() {
        head = create(null, null, 0);
        tail = head;
    }
    
    public void push(int val) {
        Node tmp = tail;
        tail = create(tmp, null, val);
        tmp.next = tail;
        tail.prev = tmp;
        if (min == null) {
            min = tail;
        } else if (min.val > val) {
            tail.prevMin = min;
            min = tail;
        }
    }
    
    public void pop() {
        if (tail != head) {
            Node tmp = tail.prev;
            tmp.next = null;
            tail.prev = null;
            if (tail == min) {
                min = tail.prevMin;
            }
            tail = tmp;
        }
    }
    
    public int top() {
        return tail.val;
    }
    
    public int getMin() {
        return min.val;
    }

    private Node create(Node prev, Node next, int val) {
        Node n = new Node();
        n.prev = prev;
        n.next = next;
        n.val = val;
        return n;
    }

    public static class Node {
        public Node prev;
        public Node next;
        public int val;
        public Node prevMin;
    }
}

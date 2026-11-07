class Deque {

    private Node start;
    private Node end;
    private int size;

    public Deque() {
        start = create(null, null, 0);
        end = start;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int value) {
       Node tmp = end;
       end = create(tmp, null, value);
       size++;
    }

    public void appendleft(int value) {
        Node n = create(start, start.next, value);
        if (size == 0) {
            end = n;
        }
        size++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        Node res = end;
        end = end.prev;
        end.next = null;
        size--;
        return res.val;
    }

    public int popleft() {
        if (size == 0) {
            return -1;
        }
        Node res = start.next;
        if (res.next != null) {
        res.next.prev = start;
        }
        start.next = res.next;
        size--;
        return res.val;
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
}

class Node {
    public Node prev;
    public Node next;
    public int val;
}

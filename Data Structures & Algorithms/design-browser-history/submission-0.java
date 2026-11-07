class BrowserHistory {

    private Node dummy = new Node();
    private Node tail;

    public BrowserHistory(String homepage) {
        tail = create(dummy, null, homepage);
    }
    
    public void visit(String url) {
        Node tmp = tail;
        tail = create(tmp, null, url);
    }
    
    public String back(int steps) {
        Node res = tail;
        
        while(steps != 0 && res != dummy.next) {
            res = res.prev;
            steps--;
        }
        tail = res;
        return tail.url;
    }
    
    public String forward(int steps) {
        Node res = tail;
        while (steps != 0 && res.next != null) {
            res = res.next;
            steps--;
        }
        tail = res;
        return tail.url;
    }

    public Node create(Node prev, Node next, String url) {
        Node n = new Node();
        n.prev = prev;
        n.next = next;
        n.url = url;
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
        public String url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
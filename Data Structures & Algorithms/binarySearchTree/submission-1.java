class TreeMap {

    public Node root;

    public TreeMap() {
        
    }

    public void insert(int key, int val) {
        if (root == null) {
            root = new Node(key, val);
        } else {
            Node cur = root;
            while (true) {
                if (key < cur.key) {
                    if (cur.left == null) {
                        cur.left = new Node(key, val);
                        break;
                    }
                    cur = cur.left;
                } else if (key > cur.key) {
                    if (cur.right == null) {
                        cur.right = new Node(key, val);
                        break;
                    }
                    cur = cur.right;
                } else {
                    cur.val = val;
                    break;
                }
            }
        }
    }

    public int get(int key) {
        var cur = root;
        while(cur != null && cur.key != key) {
            if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur != null ? cur.val : -1;
    }

    public int getMin() {
        var cur = root;
        while(cur != null && cur.left != null) {
            cur = cur.left;
        }
        return cur != null ? cur.val : -1;
    }

    public int getMax() {
        var cur = root;
        while(cur != null && cur.right != null) {
            cur = cur.right;
        }
        return cur != null ? cur.val : -1;
    }

    public void remove(int key) {
       Node parent = null;
       Node child = root;
       while(child != null && child.key != key) {
            parent = child;
            if (key < child.key) {
                child = child.left;
            } else {
                child = child.right;
            }
       }
       if (child == null) {
            return;
       }

       if (child.left == null || child.right == null) {
            Node newChild = child.left == null ? child.right : child.left;
            if (parent == null) {
                root = newChild;
                return;
            }
            if (parent.left == child) {
                parent.left = newChild;
            } else {
                parent.right = newChild;
            }
       } else {
            Node minPar = null;
            Node min = child.right;
            while(min.left != null) {
                minPar = min;
                min = min.left;
            }
            if (minPar != null) {
                minPar.left = child.right;
                min.right = child.right;
            }
            min.left = child.left;
            if (parent == null) {
                root = min;
                return;
            }
            if (parent.left == child) {
                parent.left = min;
            } else {
                parent.right = min;
            }
       }
    }

    public List<Integer> getInorderKeys() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        var cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.key);
            cur = cur.right;
        }
        return list;
    }

    public static class Node {
        public int key;
        public int val;
        public Node left;
        public Node right;

        public Node() {

        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

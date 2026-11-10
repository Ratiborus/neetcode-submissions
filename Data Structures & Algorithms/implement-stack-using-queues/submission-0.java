class MyStack {

    private Queue<Integer> one = new ArrayDeque<>();
    private Queue<Integer> two = new ArrayDeque<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        if (one.isEmpty()) {
            two.offer(x);
        } else {
            one.offer(x);
        }
    }
    
    public int pop() {
        if (one.isEmpty()) {
            return getLast(two, one);
        } else {
            return getLast(one, two);
        }
    }
    
    public int top() {
        int top = pop();
        if (one.isEmpty()) {
            two.offer(top);
        } else {
            one.offer(top);
        }
        return top;
    }
    
    public boolean empty() {
        return one.isEmpty() && two.isEmpty();
    }

    private int getLast(Queue<Integer> source, Queue<Integer> target) {
        while(source.size() > 1) {
            target.offer(source.poll());
        }
        return source.poll();
    } 
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MyStack {

    private Queue<Integer> one = new ArrayDeque<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        one.offer(x);
    }
    
    public int pop() {
        return getLast(one, one);
    }
    
    public int top() {
        int top = pop();
        one.offer(top);
        return top;
    }
    
    public boolean empty() {
        return one.isEmpty();
    }

    private int getLast(Queue<Integer> source, Queue<Integer> target) {
        int size = source.size();
        while(size > 1) {
            target.offer(source.poll());
            size--;
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
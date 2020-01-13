class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int size;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
        size = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
        for (int i = 0; i < size; i++) {
            queue2.offer(queue1.poll());
            queue1.offer(queue2.poll());
        }
        size++;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        size--;
        return queue1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
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
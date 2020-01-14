class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        stack1.push(x);
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        size++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        size--;
        return stack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
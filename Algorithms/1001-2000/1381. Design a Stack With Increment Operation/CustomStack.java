class CustomStack {
    Deque<Integer> deque;
    int capacity;
    int size;

    public CustomStack(int maxSize) {
        deque = new LinkedList<Integer>();
        capacity = maxSize;
        size = 0;
    }
    
    public void push(int x) {
        if (size < capacity) {
            deque.offerLast(x);
            size++;
        }
    }
    
    public int pop() {
        if (size > 0) {
            size--;
            return deque.pollLast();
        } else
            return -1;
    }
    
    public void increment(int k, int val) {
        k = Math.min(k, size);
        Stack<Integer> tempStack = new Stack<Integer>();
        for (int i = 0; i < k; i++) {
            int num = deque.pollFirst() + val;
            tempStack.push(num);
        }
        for (int i = 0; i < k; i++)
            deque.offerFirst(tempStack.pop());
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
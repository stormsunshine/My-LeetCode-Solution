class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<Integer>();
        maxStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty())
            maxStack.push(x);
        else {
            int prev = maxStack.peek();
            x = Math.max(x, prev);
            maxStack.push(x);
        }
    }
    
    public int pop() {
        int element = stack.pop();
        maxStack.pop();
        return element;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> tempStack = new Stack<Integer>();
        while (stack.peek() != max) {
            tempStack.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while (!tempStack.isEmpty())
            push(tempStack.pop());
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
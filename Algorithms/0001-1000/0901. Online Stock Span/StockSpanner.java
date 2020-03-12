class StockSpanner {
    Stack<Integer> pricesStack;
    Stack<Integer> indicesStack;
    int index;

    public StockSpanner() {
        pricesStack = new Stack<Integer>();
        indicesStack = new Stack<Integer>();
        index = 0;
    }
    
    public int next(int price) {
        while (!pricesStack.isEmpty() && pricesStack.peek() <= price) {
            pricesStack.pop();
            indicesStack.pop();
        }
        int prevIndex = indicesStack.isEmpty() ? -1 : indicesStack.peek();
        int span = index - prevIndex;
        pricesStack.push(price);
        indicesStack.push(index);
        index++;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
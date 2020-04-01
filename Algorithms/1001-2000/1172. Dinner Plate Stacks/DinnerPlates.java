class DinnerPlates {
    int capacity;
    TreeMap<Integer, Stack<Integer>> stackMap;
    TreeSet<Integer> availableStacks;
    int stackIndex;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stackMap = new TreeMap<Integer, Stack<Integer>>();
        availableStacks = new TreeSet<Integer>();
        stackIndex = 0;
    }
    
    public void push(int val) {
        if (availableStacks.isEmpty()) {
            Stack<Integer> stack = stackMap.getOrDefault(stackIndex, new Stack<Integer>());
            stack.push(val);
            stackMap.put(stackIndex, stack);
            if (stack.size() == capacity)
                stackIndex++;
        } else {
            int index = availableStacks.first();
            Stack<Integer> stack = stackMap.getOrDefault(index, new Stack<Integer>());
            stack.push(val);
            stackMap.put(index, stack);
            if (stack.size() == capacity)
                availableStacks.remove(index);
        }
    }
    
    public int pop() {
        if (stackMap.size() == 0)
            return -1;
        int lastKey = stackMap.lastKey();
        Stack<Integer> stack = stackMap.get(lastKey);
        int element = stack.pop();
        if (stack.isEmpty())
            stackMap.remove(lastKey);
        if (stackIndex - lastKey == 1)
            stackIndex = lastKey;
        return element;
    }
    
    public int popAtStack(int index) {
        Stack<Integer> stack = stackMap.getOrDefault(index, new Stack<Integer>());
        if (stack.isEmpty())
            return -1;
        else {
            int element = stack.pop();
            if (stack.isEmpty())
                stackMap.remove(index);
            if (stackIndex - index == 1)
                stackIndex = index;
            else if (stackIndex - index > 1)
                availableStacks.add(index);
            return element;
        }
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
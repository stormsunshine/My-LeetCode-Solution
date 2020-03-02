class FreqStack {
    Stack<Integer> stack;
    Map<Integer, Integer> numFrequencyMap;
    TreeMap<Integer, Set<Integer>> frequencySetMap;

    public FreqStack() {
        stack = new Stack<Integer>();
        numFrequencyMap = new HashMap<Integer, Integer>();
        frequencySetMap = new TreeMap<Integer, Set<Integer>>();
    }
    
    public void push(int x) {
        stack.push(x);
        int frequency = numFrequencyMap.getOrDefault(x, 0) + 1;
        numFrequencyMap.put(x, frequency);
        Set<Integer> set = frequencySetMap.getOrDefault(frequency, new HashSet<Integer>());
        set.add(x);
        frequencySetMap.put(frequency, set);
        if (frequency > 1) {
            int prevFrequency = frequency - 1;
            Set<Integer> prevFrequencySet = frequencySetMap.get(prevFrequency);
            prevFrequencySet.remove(x);
            frequencySetMap.put(prevFrequency, prevFrequencySet);
        }
    }
    
    public int pop() {
        Stack<Integer> tempStack = new Stack<Integer>();
        int maxFrequency = frequencySetMap.lastKey();
        Set<Integer> maxFrequencySet = frequencySetMap.get(maxFrequency);
        while (!stack.isEmpty() && !maxFrequencySet.contains(stack.peek()))
            tempStack.push(stack.pop());
        if (!stack.isEmpty()) {
            int popValue = stack.pop();
            maxFrequencySet.remove(popValue);
            if (maxFrequencySet.size() > 0)
                frequencySetMap.put(maxFrequency, maxFrequencySet);
            else
                frequencySetMap.remove(maxFrequency);
            int nextFrequency = maxFrequency - 1;
            if (nextFrequency > 0) {
                numFrequencyMap.put(popValue, nextFrequency);
                Set<Integer> nextFrequencySet = frequencySetMap.getOrDefault(nextFrequency, new HashSet<Integer>());
                nextFrequencySet.add(popValue);
                frequencySetMap.put(nextFrequency, nextFrequencySet);
            } else
                numFrequencyMap.remove(popValue);
            while (!tempStack.isEmpty())
                stack.push(tempStack.pop());
            return popValue;
        } else
            return -1;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
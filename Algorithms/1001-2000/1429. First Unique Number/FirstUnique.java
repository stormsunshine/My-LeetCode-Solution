class FirstUnique {
    Map<Integer, Integer> countMap;
    Queue<Integer> queue;

    public FirstUnique(int[] nums) {
        countMap = new HashMap<Integer, Integer>();
        queue = new LinkedList<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
            if (count == 1)
                queue.offer(num);
        }
        while (!queue.isEmpty() && countMap.get(queue.peek()) > 1)
            queue.poll();
    }
    
    public int showFirstUnique() {
        if (!queue.isEmpty())
            return queue.peek();
        else
            return -1;
    }
    
    public void add(int value) {
        int count = countMap.getOrDefault(value, 0) + 1;
        countMap.put(value, count);
        if (count == 1)
            queue.offer(value);
        while (!queue.isEmpty() && countMap.get(queue.peek()) > 1)
            queue.poll();
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
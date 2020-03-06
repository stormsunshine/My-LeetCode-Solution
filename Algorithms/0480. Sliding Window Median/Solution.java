class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = k % 2 == 1 ? medianSlidingWindowOdd(nums, k) : medianSlidingWindowEven(nums, k);
        return medians;
    }

    public double[] medianSlidingWindowOdd(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                if (num1 < num2)
                    return 1;
                else if (num1 > num2)
                    return -1;
                else
                    return 0;
            }
        });
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                if (num1 > num2)
                    return 1;
                else if (num1 < num2)
                    return -1;
                else
                    return 0;
            }
        });
        int length = nums.length - k + 1;
        double[] medians = new double[length];
        for (int i = 0; i < k; i++)
            priorityQueue1.offer(nums[i]);
        for (int i = k / 2; i > 0; i--)
            priorityQueue2.offer(priorityQueue1.poll());
        medians[0] = priorityQueue1.peek();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i < length; i++) {
            int prevNum = nums[i - 1];
            int count = map.getOrDefault(prevNum, 0) + 1;
            map.put(prevNum, count);
            int balance = 0;
            if (prevNum <= priorityQueue1.peek())
                balance--;
            else
                balance++;
            int newNum = nums[i + k - 1];
            if (!priorityQueue1.isEmpty() && newNum <= priorityQueue1.peek()) {
                priorityQueue1.offer(newNum);
                balance++;
            } else {
                priorityQueue2.offer(newNum);
                balance--;
            }
            if (balance < 0) {
                priorityQueue1.offer(priorityQueue2.poll());
                balance++;
            }
            if (balance > 0) {
                priorityQueue2.offer(priorityQueue1.poll());
                balance--;
            }
            while (!priorityQueue1.isEmpty() && map.containsKey(priorityQueue1.peek())) {
                int pollNum = priorityQueue1.poll();
                int newCount = map.get(pollNum) - 1;
                if (newCount > 0)
                    map.put(pollNum, newCount);
                else
                    map.remove(pollNum);
            }
            while (!priorityQueue2.isEmpty() && map.containsKey(priorityQueue2.peek())) {
                int pollNum = priorityQueue2.poll();
                int newCount = map.get(pollNum) - 1;
                if (newCount > 0)
                    map.put(pollNum, newCount);
                else
                    map.remove(pollNum);
            }
            medians[i] = priorityQueue1.peek();
        }
        return medians;
    }

    public double[] medianSlidingWindowEven(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                if (num1 < num2)
                    return 1;
                else if (num1 > num2)
                    return -1;
                else
                    return 0;
            }
        });
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                if (num1 > num2)
                    return 1;
                else if (num1 < num2)
                    return -1;
                else
                    return 0;
            }
        });
        int length = nums.length - k + 1;
        double[] medians = new double[length];
        for (int i = 0; i < k; i++)
            priorityQueue1.offer(nums[i]);
        for (int i = k / 2; i > 0; i--)
            priorityQueue2.offer(priorityQueue1.poll());
        medians[0] = (priorityQueue1.peek() * 1.0 + priorityQueue2.peek() * 1.0) / 2.0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i < length; i++) {
            int prevNum = nums[i - 1];
            int count = map.getOrDefault(prevNum, 0) + 1;
            map.put(prevNum, count);
            int balance = 0;
            if (prevNum <= priorityQueue1.peek())
                balance--;
            else
                balance++;
            int newNum = nums[i + k - 1];
            if (!priorityQueue1.isEmpty() && newNum <= priorityQueue1.peek()) {
                priorityQueue1.offer(newNum);
                balance++;
            } else {
                priorityQueue2.offer(newNum);
                balance--;
            }
            if (balance < 0) {
                priorityQueue1.offer(priorityQueue2.poll());
                balance++;
            }
            if (balance > 0) {
                priorityQueue2.offer(priorityQueue1.poll());
                balance--;
            }
            while (!priorityQueue1.isEmpty() && map.containsKey(priorityQueue1.peek())) {
                int pollNum = priorityQueue1.poll();
                int newCount = map.get(pollNum) - 1;
                if (newCount > 0)
                    map.put(pollNum, newCount);
                else
                    map.remove(pollNum);
            }
            while (!priorityQueue2.isEmpty() && map.containsKey(priorityQueue2.peek())) {
                int pollNum = priorityQueue2.poll();
                int newCount = map.get(pollNum) - 1;
                if (newCount > 0)
                    map.put(pollNum, newCount);
                else
                    map.remove(pollNum);
            }
            medians[i] = (priorityQueue1.peek() * 1.0 + priorityQueue2.peek() * 1.0) / 2.0;
        }
        return medians;
    }
}
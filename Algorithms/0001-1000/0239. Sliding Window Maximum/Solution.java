class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k == 0)
            return new int[0];
        if (k == 1)
            return nums;
        int windowsCount = length - k + 1;
        int[] maxArray = new int[windowsCount];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.getLast()] < num)
                deque.removeLast();
            deque.addLast(i);
        }
        maxArray[0] = nums[deque.getFirst()];
        for (int i = k; i < length; i++) {
            int windowIndex = i - k + 1;
            if (!deque.isEmpty() && deque.getFirst() == i - k)
                deque.removeFirst();
            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.getLast()] < num)
                deque.removeLast();
            deque.addLast(i);
            maxArray[windowIndex] = nums[deque.getFirst()];
        }
        return maxArray;
    }
}
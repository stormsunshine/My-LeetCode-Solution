class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int length = bloomDay.length;
        if (length < m * k)
            return -1;
        int[] maxArray = maxSlidingWindow(bloomDay, k);
        int low = bloomDay[0], high = bloomDay[0];
        for (int i = 1; i < length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        while (low < high) {
            int days = (high - low) / 2 + low;
            boolean flag = canMake(bloomDay, maxArray, days, m, k);
            if (flag)
                high = days;
            else
                low = days + 1;
        }
        return low;
    }

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

    public boolean canMake(int[] bloomDay, int[] maxArray, int days, int m, int k) {
        int length = bloomDay.length;
        int maxStart = length - k;
        int index = 0;
        while (index <= maxStart && m > 0) {
            if (maxArray[index] <= days) {
                m--;
                index += k;
            } else
                index++;
        }
        return m == 0;
    }
}
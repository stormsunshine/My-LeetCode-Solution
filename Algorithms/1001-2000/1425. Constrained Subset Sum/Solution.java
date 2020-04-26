class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int length = nums.length;
        int max = nums[0];
        for (int i = 1; i < length; i++)
            max = Math.max(max, nums[i]);
        if (max <= 0)
            return max;
        if (k == length)
            k--;
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        deque.addLast(0);
        int[][] dp = new int[length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i <= k; i++) {
            int num = nums[i];
            dp[i][0] = Math.max(num, dp[deque.getFirst()][0] + num);
            while (!deque.isEmpty() && dp[deque.getLast()][0] < dp[i][0])
                deque.removeLast();
            deque.addLast(i);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        for (int i = k + 1; i < length; i++) {
            if (!deque.isEmpty() && deque.getFirst() == i - k - 1)
                deque.removeFirst();
            int num = nums[i];
            dp[i][0] = Math.max(num, dp[deque.getFirst()][0] + num);
            while (!deque.isEmpty() && dp[deque.getLast()][0] < dp[i][0])
                deque.removeLast();
            deque.addLast(i);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}
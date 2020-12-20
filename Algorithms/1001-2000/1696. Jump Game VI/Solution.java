class Solution {
    public int maxResult(int[] nums, int k) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = nums[0];
        int firstMaxIndex = Math.min(length - 1, k);
        for (int i = 1; i <= firstMaxIndex; i++) {
            dp[i] = max + nums[i];
            max = Math.max(max, dp[i]);
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 1; i <= firstMaxIndex; i++) {
            int sum = dp[i];
            while (!deque.isEmpty() && dp[deque.getLast()] < sum)
                deque.removeLast();
            deque.offerLast(i);
        }
        for (int i = firstMaxIndex + 1; i < length; i++) {
            if (!deque.isEmpty() && deque.getFirst() == i - k - 1)
                deque.pollFirst();
            int num = nums[i];
            int sum = dp[deque.peekFirst()] + num;
            dp[i] = sum;
            while (!deque.isEmpty() && dp[deque.peekLast()] < sum)
                deque.pollLast();
            deque.offerLast(i);
        }
        return dp[length - 1];
    }
}
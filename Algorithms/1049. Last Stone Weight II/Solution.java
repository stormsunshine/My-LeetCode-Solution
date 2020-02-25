class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones)
            sum += stone;
        int length = stones.length;
        int capacity = sum / 2;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < length; i++) {
            int stone = stones[i];
            for (int j = capacity; j >= stone; j--)
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
        }
        int maxSum = dp[capacity];
        int remaining = sum - maxSum;
        return Math.abs(maxSum - remaining);
    }
}